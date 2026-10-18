package subsystem;

import java.nio.charset.StandardCharsets;
final class Tagged {
    private Tagged() {}

    static byte[] add(byte[] data, String tag) {
        return (tag + new String(data, StandardCharsets.UTF_8)).getBytes(StandardCharsets.UTF_8);
    }

    static byte[] strip(byte[] data, String tag) {
        String s = new String(data, StandardCharsets.UTF_8);
        return (s.startsWith(tag) ? s.substring(tag.length()) : s).getBytes(StandardCharsets.UTF_8);
    }
}
