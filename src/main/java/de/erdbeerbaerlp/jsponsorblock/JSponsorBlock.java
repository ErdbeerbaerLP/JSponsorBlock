package de.erdbeerbaerlp.jsponsorblock;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JSponsorBlock {
    /**
     * Base API URL for SponsorBlock
     */
    public static String API_URL = "https://sponsor.ajay.app/api/";

    /**
     * Gets an segment for an youtube video
     * @param videoID video ID of the youtube video
     * @return all segments from that video
     * @throws IOException on error and when video was not found
     */
    public static Segment[] getSkipableSegments(String videoID) throws IOException {
        return getJson(API_URL+"skipSegments?videoID="+videoID, Segment[].class);
    }
    /**
     * Gets an segment for an video for an service
     * @param videoID video ID of the video
     * @param service video service
     * @return all segments from that video
     * @throws IOException on error and when video was not found
     */
    public static Segment[] getSkipableSegments(String videoID, String service) throws IOException {
        return getJson(API_URL+"skipSegments?videoID="+videoID+"&service="+service, Segment[].class);
    }


    /**
     * Gets an segment for an youtube video
     * @param sha256Prefix sha256 hash of the YouTube videoID. It should be the first 4 - 32 characters (4 is recommended). This provides extra privacy by potentially finding more than just the video you are looking for since the server will not know exactly what video you are looking for.
     * @return all segments from that video
     * @throws IOException on error and when video was not found
     */
    public static Segment[] getSkipableSegmentsFromSha256(String sha256Prefix) throws IOException {

        return getJson(API_URL+"skipSegments/:"+sha256Prefix, Segment[].class);
    }

    /**
     * Gets an segment for an video for an service
     * @param sha256Prefix SHA256 of the video ID of the video
     * @param service video service
     * @return all segments from that video
     * @throws IOException on error and when video was not found
     */
    public static Segment[] getSkipableSegmentsFromSha256(String sha256Prefix, String service) throws IOException {

        return getJson(API_URL+"skipSegments/:"+sha256Prefix+"?service="+service, Segment[].class);
    }

    private static final Gson gson = new Gson();
    private static <T> T getJson(String url, Class<T> clazz) throws IOException{
        final HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
        conn.connect();
        final InputStreamReader ir = new InputStreamReader(conn.getInputStream());
        final T t = gson.fromJson(ir,clazz);
        ir.close();
        return t;
    }


}
