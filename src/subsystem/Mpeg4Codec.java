package subsystem;


public class Mpeg4Codec implements Codec {
    private static final String TAG = "[MPEG4]";

    @Override public String name() { return "MPEG4"; }

    @Override public byte[] decode(byte[] stream) {
        return Tagged.strip(stream, TAG);
    }

    @Override public byte[] encode(byte[] rawFrames) {
        return Tagged.add(rawFrames, TAG);
    }
}
