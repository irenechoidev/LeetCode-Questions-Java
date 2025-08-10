public class Codec {

    Map<String, String> encodeMap = new HashMap<>();
    Map<String, String> decodeMap = new HashMap<>();
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String getCode() {

        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = chars.charAt((int) (Math.random() * 62));
        }

        return "http://tinyurl.com/" + String.valueOf(arr);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String code = getCode();

        encodeMap.put(longUrl, code);
        decodeMap.put(code, longUrl);

        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));