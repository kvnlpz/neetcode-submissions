class Twitter {

    int timestamp = 0;
    Map<Integer, Set<Integer>> followers;
    Map<Integer, List<Tweet>> tweets;

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private static class TweetPointer {
        List<Tweet> tweets;
        int index;

        TweetPointer(List<Tweet> tweets) {
            this.tweets = tweets;
            this.index = tweets.size() - 1; // Always making the index be the last tweet's index

        }

        Tweet current() {
            return tweets.get(index);
        }
    }
    public Twitter() {
        this.followers = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(
            userId, k ->  new ArrayList<Tweet>()).add(new Tweet(tweetId, timestamp++)); // standard increasing time
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // We need to sort by time so maxHeap 
        PriorityQueue<TweetPointer> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.current().time, a.current().time)
        );
        
        // Get all their followees first
        Set<Integer> usersToPull = new HashSet<>();
        usersToPull.add(userId);
        if (followers.containsKey(userId)) {
            usersToPull.addAll(followers.get(userId));
        }
        

        for (int user : usersToPull) {
            // check if the user is in the tweet map and if they have tweets
            if (tweets.containsKey(user) && !tweets.get(user).isEmpty()) {
                maxHeap.offer(new TweetPointer(tweets.get(user)));
            }
        }

        // Now that the maxHeap has all the tweets for all the users being followed, we need to merge the lists 
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            TweetPointer pointer = maxHeap.poll();
            feed.add(pointer.current().id);
            // Since we got only the last tweet we still need to get the rest if there's more in there, so we move the pointer back, and then re-add the pointer into the maxHeap 
            if (pointer.index > 0) {
                pointer.index--;
                maxHeap.offer(pointer);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
         
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
        
    }
}
