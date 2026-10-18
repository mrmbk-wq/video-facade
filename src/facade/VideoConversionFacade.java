package facade;

import subsystem.AudioMixer;
import subsystem.BitrateReader;
import subsystem.Codec;
import subsystem.CodecFactory;
import subsystem.VideoFile;
public class VideoConversionFacade {
    private final CodecFactory codecFactory;
    private final BitrateReader bitrateReader;
    private final AudioMixer audioMixer;

    public VideoConversionFacade() {
        this(new CodecFactory(), new BitrateReader(), new AudioMixer());
    }
    public VideoConversionFacade(CodecFactory codecFactory, BitrateReader bitrateReader, AudioMixer audioMixer) {
        this.codecFactory = codecFactory;
        this.bitrateReader = bitrateReader;
        this.audioMixer = audioMixer;
    }

    public String convert(String filename, String targetFormat) throws VideoConversionException {
        try {
            VideoFile source = VideoFile.fromFilename(filename);
            Codec sourceCodec = codecFactory.forFormat(source.format());
            Codec targetCodec = codecFactory.forFormat(targetFormat);

            byte[] raw = bitrateReader.read(source, sourceCodec);
            byte[] encoded = bitrateReader.write(raw, targetCodec);
            byte[] result = audioMixer.normalize(encoded);

            return source.baseName() + "." + targetFormat.toLowerCase() + " (" + result.length + " bytes)";
        } catch (IllegalArgumentException e) {
            throw new VideoConversionException("Cannot convert '" + filename + "' to '" + targetFormat + "'", e);
        }
    }

    public boolean isFormatSupported(String format) {
        return codecFactory.supports(format);
    }
}
