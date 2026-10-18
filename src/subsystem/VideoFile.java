package subsystem;
public record VideoFile(String name, String format) {

    public static VideoFile fromFilename(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot <= 0 || dot == filename.length() - 1) {
            throw new IllegalArgumentException("File has no extension: " + filename);
        }
        return new VideoFile(filename, filename.substring(dot + 1).toLowerCase());
    }

    public String baseName() {
        return name.substring(0, name.lastIndexOf('.'));
    }
}
