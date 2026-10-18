package subsystem;

import java.util.Map;
import java.util.function.Supplier;
public class CodecFactory {
    private static final Map<String, Supplier<Codec>> CODECS = Map.of(
            "mp4", Mpeg4Codec::new,
            "ogg", OggCodec::new,
            "mkv", H264Codec::new
    );

    public Codec forFormat(String format) {
        Supplier<Codec> supplier = CODECS.get(format.toLowerCase());
        if (supplier == null) {
            throw new IllegalArgumentException("No codec for format: " + format);
        }
        return supplier.get();
    }

    public boolean supports(String format) {
        return CODECS.containsKey(format.toLowerCase());
    }
}
