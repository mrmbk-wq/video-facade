package subsystem;

public class H264Codec implements Codec {
    private static final String TAG = "[H264]";

    @Override public String name() { return "H264"; }
    @Override public byte[] decode(byte[] stream) { return Tagged.strip(stream, TAG); }
    @Override public byte[] encode(byte[] rawFrames) { return Tagged.add(rawFrames, TAG); }
}
