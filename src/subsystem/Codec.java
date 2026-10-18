package subsystem;
public interface Codec {
    String name();
    byte[] decode(byte[] stream);
    byte[] encode(byte[] rawFrames);
}
