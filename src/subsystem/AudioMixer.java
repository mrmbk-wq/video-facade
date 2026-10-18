package subsystem;
public class AudioMixer {

    public byte[] normalize(byte[] stream) {
        System.out.println("AudioMixer: normalizing audio (" + stream.length + " bytes)");
        return stream;
    }
}
