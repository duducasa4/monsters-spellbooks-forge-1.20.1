package net.redreaper.monsterspellbooks.compat120;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.phys.Vec2;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * Same use as Iron's RenderHelper.quadBuilder(), but writes each vertex in the element order 1.20.1's BufferBuilder
 * expects (position, color, uv, overlay, light, normal). The 1.21 vertex API takes them in any order; in 1.20.1 an
 * element written out of order is skipped and the vertex ends up incomplete.
 */
public final class QuadBuilder {
    private final List<Vector3f> vertices = new ArrayList<>();
    private final List<Vector3f> normals = new ArrayList<>();
    private final List<Vec2> uvs = new ArrayList<>();
    private final List<float[]> colors = new ArrayList<>();
    private Integer light;
    private Integer overlay;
    private Matrix4f matrix;
    private Matrix3f normalMatrix;

    public static QuadBuilder quadBuilder() {
        return new QuadBuilder();
    }

    public QuadBuilder vertex(float x, float y, float z) {
        vertices.add(new Vector3f(x, y, z));
        return this;
    }

    public QuadBuilder uv(float u, float v) {
        uvs.add(new Vec2(u, v));
        return this;
    }

    public QuadBuilder normal(float x, float y, float z) {
        normals.add(new Vector3f(x, y, z));
        return this;
    }

    public QuadBuilder normal(Matrix3f normalMatrix, float x, float y, float z) {
        this.normalMatrix = normalMatrix;
        return normal(x, y, z);
    }

    public QuadBuilder matrix(Matrix4f matrix) {
        this.matrix = matrix;
        return this;
    }

    public QuadBuilder color(float r, float g, float b) {
        return color(r, g, b, 1f);
    }

    public QuadBuilder color(float r, float g, float b, float a) {
        colors.add(new float[]{r, g, b, a});
        return this;
    }

    public QuadBuilder light(int light) {
        this.light = light;
        return this;
    }

    public QuadBuilder overlay(int overlay) {
        this.overlay = overlay;
        return this;
    }

    public void build(VertexConsumer consumer) {
        for (int i = 0; i < vertices.size(); i++) {
            Vector3f v = vertices.get(i);
            if (matrix != null) {
                consumer.vertex(matrix, v.x, v.y, v.z);
            } else {
                consumer.vertex(v.x, v.y, v.z);
            }
            float[] c = colors.isEmpty() ? new float[]{1f, 1f, 1f, 1f} : colors.size() == vertices.size() ? colors.get(i) : colors.get(0);
            consumer.color(c[0], c[1], c[2], c[3]);
            if (!uvs.isEmpty()) {
                Vec2 uv = uvs.get(i);
                consumer.uv(uv.x, uv.y);
            }
            if (overlay != null) {
                consumer.overlayCoords(overlay);
            }
            if (light != null) {
                consumer.uv2(light);
            }
            if (!normals.isEmpty()) {
                Vector3f n = normals.get(i);
                if (normalMatrix != null) {
                    consumer.normal(normalMatrix, n.x, n.y, n.z);
                } else {
                    consumer.normal(n.x, n.y, n.z);
                }
            }
            consumer.endVertex();
        }
    }
}
