package app.revanced.extension.spotify.misc.privacy;

import android.net.Uri;
import app.revanced.extension.shared.utils.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public final class SanitizeSharingLinksPatch {
    public static String sanitizeUrl(String url, String parameters) {
        try {
            Uri uri = Uri.parse(url);
            Uri.Builder builder = uri.buildUpon().clearQuery();

            Set<String> paramsToRemove = new HashSet<>(Arrays.asList(parameters.split(",\\s*")));

            for (String paramName : uri.getQueryParameterNames()) {
                if (!paramsToRemove.contains(paramName)) {
                    for (String value : uri.getQueryParameters(paramName)) {
                        builder.appendQueryParameter(paramName, value);
                    }
                }
            }

            return builder.build().toString();
        } catch (Exception ex) {
            Logger.printException(() -> "sanitizeUrl failure", ex);

            return url;
        }
    }
}
