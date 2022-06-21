package java.awt;



/**
 * The <code>Ellipse2D</code> class describes an ellipse that is defined
 * by a framing rectangle.
 * <p>
 * This class is only the abstract superclass for all objects which
 * store a 2D ellipse.
 * The actual storage representation of the coordinates is left to
 * the subclass.
 *
 * @author      Jim Graham
 * @since 1.2
 */
public class Ellipse2D{
        /**
         * The X coordinate of the upper-left corner of the
         * framing rectangle of this {@code Ellipse2D}.
         * @since 1.2
         * @serial
         */
        public int x;

        /**
         * The Y coordinate of the upper-left corner of the
         * framing rectangle of this {@code Ellipse2D}.
         * @since 1.2
         * @serial
         */
        public int y;

        /**
         * The overall width of this <code>Ellipse2D</code>.
         * @since 1.2
         * @serial
         */
        public int width;

        /**
         * The overall height of the <code>Ellipse2D</code>.
         * @since 1.2
         * @serial
         */
        public int height;

        /**
         * Constructs a new <code>Ellipse2D</code>, initialized to
         * location (0,&nbsp;0) and size (0,&nbsp;0).
         * @since 1.2
         */
        public Ellipse2D() {
        }

        /**
         * Constructs and initializes an <code>Ellipse2D</code> from the
         * specified coordinates.
         *
         * @param x the X coordinate of the upper-left corner
         *        of the framing rectangle
         * @param y the Y coordinate of the upper-left corner
         *        of the framing rectangle
         * @param w the width of the framing rectangle
         * @param h the height of the framing rectangle
         * @since 1.2
         */
        public Ellipse2D(int x, int y, int w, int h) {
            setFrame(x, y, w, h);
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public int getX() {
            return x;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public int getY() {
            return y;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public int getWidth() {
            return width;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public int getHeight() {
            return height;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public boolean isEmpty() {
            return (width <= 0.0 || height <= 0.0);
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public void setFrame(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.width = w;
            this.height = h;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public Rectangle getBounds2D() {
            return new Rectangle(x, y, width, height);
        }

        /*
         * JDK 1.6 serialVersionUID
         */
        private static final long serialVersionUID = 5555464816372320683L;

    /**
     * This is an abstract class that cannot be instantiated directly.
     * Type-specific implementation subclasses are available for
     * instantiation and provide a number of formats for storing
     * the information necessary to satisfy the various accessor
     * methods below.
     *
     * @see java.awt.geom.Ellipse2D.Float
     * @see java.awt.geom.Ellipse2D.int
     * @since 1.2
     */

    /**
     * {@inheritDoc}
     * @since 1.2
     */
    public boolean contains(int x, int y) {
        // Normalize the coordinates compared to the ellipse
        // having a center at 0,0 and a radius of 0.5.
        double ellw = getWidth();
        if (ellw <= 0.0) {
            return false;
        }
        double normx = (x - getX()) / ellw - 0.5;
        double ellh = getHeight();
        if (ellh <= 0.0) {
            return false;
        }
        double normy = (y - getY()) / ellh - 0.5;
        return (normx * normx + normy * normy) < 0.25;
    }

    /**
     * {@inheritDoc}
     * @since 1.2
     */
    public boolean intersects(int x, int y, int w, int h) {
        if (w <= 0.0 || h <= 0.0) {
            return false;
        }
        // Normalize the rectangular coordinates compared to the ellipse
        // having a center at 0,0 and a radius of 0.5.
        int ellw = getWidth();
        if (ellw <= 0.0) {
            return false;
        }
        double normx0 = (x - getX()) / ellw - 0.5;
        double normx1 = normx0 + w / ellw;
        int ellh = getHeight();
        if (ellh <= 0.0) {
            return false;
        }
        double normy0 = (y - getY()) / ellh - 0.5;
        double normy1 = normy0 + h / ellh;
        // find nearest x (left edge, right edge, 0.0)
        // find nearest y (top edge, bottom edge, 0.0)
        // if nearest x,y is inside circle of radius 0.5, then intersects
        double nearx, neary;
        if (normx0 > 0.0) {
            // center to left of X extents
            nearx = (int)normx0;
        } else if (normx1 < 0.0) {
            // center to right of X extents
            nearx = (int)normx1;
        } else {
            nearx = 0.0;
        }
        if (normy0 > 0) {
            // center above Y extents
            neary = normy0;
        } else if (normy1 < 0) {
            // center below Y extents
            neary = normy1;
        } else {
            neary = 0;
        }
        return (nearx * nearx + neary * neary) < 0.25;
    }

    /**
     * {@inheritDoc}
     * @since 1.2
     */
    public boolean contains(int x, int y, int w, int h) {
        return (contains(x, y) &&
                contains(x + w, y) &&
                contains(x, y + h) &&
                contains(x + w, y + h));
    }

    /**
     * Returns an iteration object that defines the boundary of this
     * <code>Ellipse2D</code>.
     * The iterator for this class is multi-threaded safe, which means
     * that this <code>Ellipse2D</code> class guarantees that
     * modifications to the geometry of this <code>Ellipse2D</code>
     * object do not affect any iterations of that geometry that
     * are already in process.
     * @param at an optional <code>AffineTransform</code> to be applied to
     * the coordinates as they are returned in the iteration, or
     * <code>null</code> if untransformed coordinates are desired
     * @return    the <code>PathIterator</code> object that returns the
     *          geometry of the outline of this <code>Ellipse2D</code>,
     *          one segment at a time.
     * @since 1.2
     */
//    public PathIterator getPathIterator(AffineTransform at) {
//        return new EllipseIterator(this, at);
//    }

    /**
     * Returns the hashcode for this <code>Ellipse2D</code>.
     * @return the hashcode for this <code>Ellipse2D</code>.
     * @since 1.6
     */
//    public int hashCode() {
//        long bits = java.lang.int.intToLongBits(getX());
//        bits += java.lang.int.intToLongBits(getY()) * 37;
//        bits += java.lang.int.intToLongBits(getWidth()) * 43;
//        bits += java.lang.int.intToLongBits(getHeight()) * 47;
//        return (((int) bits) ^ ((int) (bits >> 32)));
//    }

    /**
     * Determines whether or not the specified <code>Object</code> is
     * equal to this <code>Ellipse2D</code>.  The specified
     * <code>Object</code> is equal to this <code>Ellipse2D</code>
     * if it is an instance of <code>Ellipse2D</code> and if its
     * location and size are the same as this <code>Ellipse2D</code>.
     * @param obj  an <code>Object</code> to be compared with this
     *             <code>Ellipse2D</code>.
     * @return  <code>true</code> if <code>obj</code> is an instance
     *          of <code>Ellipse2D</code> and has the same values;
     *          <code>false</code> otherwise.
     * @since 1.6
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Ellipse2D) {
            Ellipse2D e2d = (Ellipse2D) obj;
            return ((getX() == e2d.getX()) &&
                    (getY() == e2d.getY()) &&
                    (getWidth() == e2d.getWidth()) &&
                    (getHeight() == e2d.getHeight()));
        }
        return false;
    }
}
