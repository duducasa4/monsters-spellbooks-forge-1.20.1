package net.redreaper.monsterspellbooks.compat120;

/** 1.21 passes colours to models/renderers as one ARGB int; 1.20.1 wants four floats. */
public final class Col {
    private Col() {
    }

    public static float a(int argb) {
        return ((argb >>> 24) & 0xFF) / 255f;
    }

    public static float r(int argb) {
        return ((argb >> 16) & 0xFF) / 255f;
    }

    public static float g(int argb) {
        return ((argb >> 8) & 0xFF) / 255f;
    }

    public static float b(int argb) {
        return (argb & 0xFF) / 255f;
    }

    /** Back to ARGB from 1.20.1's floats. */
    public static int argb(float r, float g, float b, float a) {
        return ((int) (a * 255) & 0xFF) << 24 | ((int) (r * 255) & 0xFF) << 16 | ((int) (g * 255) & 0xFF) << 8 | ((int) (b * 255) & 0xFF);
    }
}
