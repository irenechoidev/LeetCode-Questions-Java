class Twitter {
    Map<Integer, PriorityQueue<Tweet>> userTweets;
    Map<Integer, Set<Integer>> userFollowers;
    Map<Integer, Set<Integer>> userFollowing;
    int timestamp;

    public Twitter() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
        userFollowing = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new PriorityQueue<>(
                (t1, t2) -> t2.timestamp - t1.timestamp));

        Tweet tweet = new Tweet();
        tweet.tweetId = tweetId;
        tweet.timestamp = timestamp;
        tweet.userId = userId;

        timestamp += 1;

        userTweets.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> toAddBack = new ArrayList<>();
        PriorityQueue<Tweet> allTweets = new PriorityQueue<>(
                (t1, t2) -> t2.timestamp - t1.timestamp);

        // Add all tweets from the people I follow to the heap
        Set<Integer> myFollowingSet = getFollowingIds(userId);
        // Set to List
        List<Integer> myFollowing = new ArrayList<>(myFollowingSet);
        for (int id : myFollowing) {
            PriorityQueue<Tweet> followingTweets = getTweets(id);

            while (!followingTweets.isEmpty()) {
                Tweet tweet = followingTweets.poll();
                toAddBack.add(tweet);
                allTweets.add(tweet);
            }
        }

        // Add all my tweets to the heap
        PriorityQueue<Tweet> myTweets = getTweets(userId);
        while (!myTweets.isEmpty()) {
            Tweet tweet = myTweets.poll();
            toAddBack.add(tweet);
            allTweets.add(tweet);
        }

        // Remove the top 10 tweets from the heap
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            // If statement is in case we have less than 10 tweets
            if (!allTweets.isEmpty()) {
                Tweet tweet = allTweets.poll();
                result.add(tweet.tweetId);
            }
        }

        // Add every tweet back to the userTweets map
        for (Tweet tweet : toAddBack) {
            userTweets.get(tweet.userId).add(tweet);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        userFollowers.putIfAbsent(followeeId, new HashSet<>());
        userFollowing.putIfAbsent(followerId, new HashSet<>());

        userFollowers.get(followeeId).add(followerId);
        userFollowing.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = userFollowers.get(followeeId);
        Set<Integer> following = userFollowing.get(followerId);

        if (followers != null) {
            followers.remove(followerId);
        }
        if (following != null) {
            following.remove(followeeId);
        }
    }

    private Set<Integer> getFollowingIds(int userId) {
        return userFollowing.getOrDefault(userId, new HashSet<>());
    }

    private PriorityQueue<Tweet> getTweets(int userId) {
        return userTweets.getOrDefault(userId, new PriorityQueue<>());
    }

    class Tweet {
        int tweetId;
        int timestamp;
        int userId;
    }
}
