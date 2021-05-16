public class Gravity {
    public double falling(double time, double velo) {
        double meters = velo * time + 0.5 * 9.8 * time * time;
        return meters;
    }
}