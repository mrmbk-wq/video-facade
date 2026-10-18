package subsystem;

import java.nio.charset.StandardCharsets;
public class BitrateReader {

    public byte[] read(VideoFile file, Codec sourceCodec) {
        System.out.println("BitrateReader: reading " + file.name() + " with " + sourceCodec.name());
        byte[] stream = sourceCodec.encode(("frames-of-" + file.baseName()).getBytes(StandardCharsets.UTF_8));
        return sourceCodec.decode(stream);
    }

    public byte[] write(byte[] rawFrames, Codec targetCodec) {
        System.out.println("BitrateReader: writing with " + targetCodec.name());
        return targetCodec.encode(rawFrames);
    }
}
