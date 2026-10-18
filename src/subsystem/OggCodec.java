package subsystem;

public class OggCodec implements Codec {
    private static final String TAG = "[OGG]";

    @Override public String name() { return "OGG"; }
    @Override public byte[] decode(byte[] stream) { return Tagged.strip(stream, TAG); }
    @Override public byte[] encode(byte[] rawFrames) { return Tagged.add(rawFrames, TAG); }
}
