package net.greg.examples.webhook;

import java.io.*;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.*;


/**
 *
 */
public final class SlackHandler {

  // Handler | Verb: POST
  public static final void POST(final String message) {

    try (

    final CloseableHttpClient proxy = HttpClients.createDefault()) {

      final HttpPost POST = new HttpPost(SLACK_ENDPOINT);

      POST.setHeader(HEADER_ACCEPT, META_JSON);
      POST.setHeader(HEADER_CONTENT, META_JSON);

      POST.setEntity(
        new StringEntity(PROLOG + message + EPILOG));

      proxy.execute(POST);
    }
    catch (UnsupportedEncodingException e) { e.printStackTrace(); }
    catch (IOException e) { e.printStackTrace(); }
  }


  private static final String SLACK_URI =
    "https://hooks.slack.com/services/";

  private static final String SLACK_SECRET =
    "TBGTX8UMS/B01FMDZERAM/kbxYrnBXlgfAZBujopAc10v6";

  private static final String SLACK_ENDPOINT =
    SLACK_URI + SLACK_SECRET;


  private static final String HEADER_ACCEPT = "Accept";
  private static final String HEADER_CONTENT = "Content-type";
  private static final String META_JSON = "application/json";

  private static final String PROLOG = "{\"text\":\"";
  private static final String EPILOG = "\"}";
}
