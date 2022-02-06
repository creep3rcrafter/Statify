package creep3rcrafter.math;

import java.util.Random;

public class BetterMath {

    public void Example (){
        float f = 0f;
        double d = 0;
        int i = 0;
        long l = 0;

        f = totalDistance(1f);
        d = totalDistance(1.0);
        i = totalDistance( 1);
        l = totalDistance((long) 1);
        f = radiusToCircumference(1f);
        d = radiusToCircumference(1.0);
    }

    public enum Axis{
        X,Y
    }
    public enum Unit {
        DEGREES, RADIANS, MAGNATUDE, MAGNATUDE_X, MAGNATUDE_Y
    }
    public enum Directions{
        NORTH(0,1, 0),
        SOUTH(0,-1, 0),
        EAST(1,0, 0),
        WEST(-1,0, 0),
        UP(0,0, 1),
        DOWN(0,0, -1),
        Left(-1,0, 0),
        RIGHT(1,0, 0),
        FORWARD(0,1, 0),
        BACKWARD(0,-1, 0),
        ZERO(0,0, 0);
        Directions(int x, int y, int z) {
        }
    }
    
    
    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
    public static long clamp(long val, long min, long max) {
        return Math.max(min, Math.min(max, val));
    }

    /**Gets the distance between 2 numbers
     * if more than 2 paramaters are added
     * it adds the total of all of them.
     * @param var Enter 2 or more floats if only one is entered it will return the abs of var
     * **/
    public static float totalDistance (float... var){
        float total = 0;
        for (float Var : var){
            total = total + Math.abs(Var);
        }
        return total;
    }
    /**Gets the distance between 2 numbers
     * if more than 2 paramaters are added
     * it adds the total of all of them.
     * @param var Enter 2 or more doubles if only one is entered it will return the abs of var
     * **/
    public static double totalDistance (double... var){
        double total = 0;
        for (double Var : var){
            total = total + Math.abs(Var);
        }
        return total;
    }
    /**Gets the distance between 2 numbers
     * if more than 2 paramaters are added
     * it adds the total of all of them.
     * @param var Enter 2 or more ints if only one is entered it will return the abs of var
     * **/
    public static int totalDistance (int... var){
        int total = 0;
        for (int Var : var){
            total = total + Math.abs(Var);
        }
        return total;
    }
    /**Gets the distance between 2 numbers
     * if more than 2 paramaters are added
     * it adds the total of all of them.
     * @param var Enter 2 or more longs if only one is entered it will return the abs of var
     * **/
    public static long totalDistance (long... var){
        long total = 0;
        for (long Var : var){
            total = total + Math.abs(Var);
        }
        return total;
    }

    /**Converts Radius to Circumfrence
     * @param radius Enter a (float) of the radius you need to calculate
     * **/
    public static float radiusToCircumference (float radius){ return (float) (2 * Math.PI * radius); }
    /**Converts Radius to Circumfrence
     * @param radius Enter a (double) of the radius you need to calculate
     * **/
    public static double radiusToCircumference (double radius){ return 2 * Math.PI * radius; }

    public static float degToRad (float degrees){ return (float) ((degrees / 180) * Math.PI); }
    public static double degToRad (double degrees){ return (degrees / 180) * Math.PI; }

    public static float radToDeg (float Rad){ return (float) (Rad * 180 / Math.PI); }
    public static double radToDeg (double Rad){ return Rad * 180 / Math.PI; }

    public static float lerp(float a, float b, float t){ return a + (b - a) * t; }
    public static double lerp(double a, double b, double t){ return a + (b - a) * t; }
    public static int lerp(int a, int b, int t){ return a + (b - a) * t; }
    public static long lerp(long a, long b, long t){ return a + (b - a) * t; }

    public static float getXorYMagnitudeOfAngle(float input, Axis axis, Unit unit){
        if (unit == Unit.RADIANS){
            if(axis == Axis.X){
                return (float) Math.cos(input);
            }else if(axis == Axis.Y){
                return (float) Math.sin(input);
            }else{
                return 0f;
            }
        }else if (unit == Unit.DEGREES){
            if(axis == Axis.X){
                return (float) Math.cos(degToRad(input));
            }else if(axis == Axis.Y){
                return (float) Math.sin(degToRad(input));
            }else{
                return 0f;
            }
        }else{
            return 0f;
        }
    }
    public static double getXorYMagnitudeOfAngle(double input, Axis axis, Unit unit){
        if (unit == Unit.RADIANS){
            if(axis == Axis.X){
                return Math.cos(input);
            }else if(axis == Axis.Y){
                return Math.sin(input);
            }else{
                return 0.0;
            }
        }else if (unit == Unit.DEGREES){
            if(axis == Axis.X){
                return Math.cos(degToRad(input));
            }else if(axis == Axis.Y){
                return Math.sin(degToRad(input));
            }else{
                return 0.0;
            }
        }else{
            return 0.0;
        }
    }

    public static float randRange(float min, float max) {
        Random rand = new Random();
        return rand.nextFloat() * (max - min) + min;
    }
    public static double randRange(double min, double max) {
        Random rand = new Random();
        return rand.nextDouble() * (max - min) + min;
    }
    public static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt() * (max - min) + min;
    }
    public static long randRange(long min, long max) {
        Random rand = new Random();
        return rand.nextLong() * (max - min) + min;
    }

    public static float roundToDecPlace (float input, int decimalPlaces){
        int places = (int) Math.pow(10, decimalPlaces);
        return (float) Math.round(input * places) / (float)places;
    }
    public static double roundToDecPlace (double input, int decimalPlaces){
        int places = (int) Math.pow(10, decimalPlaces);
        return (double) Math.round(input * places) / (double)places;
    }

    public static float map(float x, float inMin, float inMax, float outMin, float outMax) {
        return (x - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }
    public static double map(double x, double inMin, double inMax, double outMin, double outMax) {
        return (x - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }
    public static int map(int x, int inMin, int inMax, int outMin, int outMax) {
        return (x - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }
    public static long map(long x, long inMin, long inMax, long outMin, long outMax) {
        return (x - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }

    public static float max (float... var){
        float lastMax = var[0];
        for(Float Var : var){
            lastMax = Math.max(lastMax, Var);
        }
        return lastMax;
    }
    public static double max (double... var){
        double lastMax = var[0];
        for(double Var : var){
            lastMax = Math.max(lastMax, Var);
        }
        return lastMax;
    }
    public static int max (int... var){
        int lastMax = var[0];
        for(int Var : var){
            lastMax = Math.max(lastMax, Var);
        }
        return lastMax;
    }
    public static long max (long... var){
        long lastMax = var[0];
        for(long Var : var){
            lastMax = Math.max(lastMax, Var);
        }
        return lastMax;
    }

    public static float min (float... var){
        float lastMin = var[0];
        for(Float Var : var){
            lastMin = Math.min(lastMin, Var);
        }
        return lastMin;
    }
    public static double min (double... var){
        double lastMin = var[0];
        for(double Var : var){
            lastMin = Math.min(lastMin, Var);
        }
        return lastMin;
    }
    public static int min (int... var){
        int lastMin = var[0];
        for(int Var : var){
            lastMin = Math.min(lastMin, Var);
        }
        return lastMin;
    }
    public static long min (long... var){
        long lastMin = var[0];
        for(long Var : var){
            lastMin = Math.min(lastMin, Var);
        }
        return lastMin;
    }

    //Basic Math Operations
    //Add
    public static float add(float... var){
        float total = 0;
        for (float Var : var){
            total = total + Var;
        }
        return total;
    }
    public static double add(double... var){
        double total = 0;
        for (double Var : var){
            total = total + Var;
        }
        return total;
    }
    public static int add(int... var){
        int total = 0;
        for (int Var : var){
            total = total + Var;
        }
        return total;
    }
    public static long add(long... var){
        long total = 0;
        for (long Var : var){
            total = total + Var;
        }
        return total;
    }
    //Subtract
    public static float subtract(float... var){
        float total = 0;
        for (float Var : var){
            total = total - Var;
        }
        return total;
    }
    public static double subtract(double... var){
        double total = 0;
        for (double Var : var){
            total = total - Var;
        }
        return total;
    }
    public static int subtract(int... var){
        int total = 0;
        for (int Var : var){
            total = total - Var;
        }
        return total;
    }
    public static long subtract(long... var){
        long total = 0;
        for (long Var : var){
            total = total - Var;
        }
        return total;
    }
    //multiply
    public static float multiply(float... var){
        float total = var[0];
        for (int i = 1; i < var.length; i++){
            total = total * var[i];
        }
        return total;
    }
    public static double multiply(double... var){
        double total = 0;
        for (int i = 1; i < var.length; i++){
            total = total * var[i];
        }
        return total;
    }
    public static int multiply(int... var){
        int total = 0;
        for (int i = 1; i < var.length; i++){
            total = total * var[i];
        }
        return total;
    }
    public static long multiply(long... var){
        long total = 0;
        for (int i = 1; i < var.length; i++){
            total = total * var[i];
        }
        return total;
    }
    //divide
    public static float divide(float... var){
        float total = var[0];
        for (int i = 1; i < var.length; i++){
            total = total / var[i];
        }
        return total;
    }
    public static double divide(double... var){
        double total = 0;
        for (int i = 1; i < var.length; i++){
            total = total / var[i];
        }
        return total;
    }
    public static int divide(int... var){
        int total = 0;
        for (int i = 1; i < var.length; i++){
            total = total / var[i];
        }
        return total;
    }
    public static long divide(long... var){
        long total = 0;
        for (int i = 1; i < var.length; i++){
            total = total / var[i];
        }
        return total;
    }

    //mean
    public static float mean(float... var){
        return add(var) / var.length;
    }
    public static double mean(double... var){
        return add(var) / var.length;
    }
    public static int mean(int... var){
        return add(var) / var.length;
    }
    public static long mean(long... var){
        return add(var) / var.length;
    }
    //median
    public static float median(float... var){
        if(var.length%2==1)
        {
            return var[(var.length+1)/2-1];
        }
        else
        {
            return (var[var.length/2-1]+var[var.length/2])/2;
        }
    }
    public static double median(double... var){
        if(var.length%2==1)
        {
            return var[(var.length+1)/2-1];
        }
        else
        {
            return (var[var.length/2-1]+var[var.length/2])/2;
        }
    }
    public static int median(int... var){
        if(var.length%2==1)
        {
            return var[(var.length+1)/2-1];
        }
        else
        {
            return (var[var.length/2-1]+var[var.length/2])/2;
        }
    }
    public static long median(long... var){
        if(var.length%2==1)
        {
            return var[(var.length+1)/2-1];
        }
        else
        {
            return (var[var.length/2-1]+var[var.length/2])/2;
        }
    }
    //mode
    public static float mode(float... var){
        float mostOccured = 0;
        int maxCount = 0;
        for (int i = 0; i < var.length; i++){
            int count = 0;
            for (int j = 0; j < var.length; j++){
                if (var[j] == var[i]){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                mostOccured = var[i];
            }
        }
        return mostOccured;
    }
    public static double mode(double... var){
        double mostOccured = 0;
        int maxCount = 0;
        for (int i = 0; i < var.length; i++){
            int count = 0;
            for (int j = 0; j < var.length; j++){
                if (var[j] == var[i]){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                mostOccured = var[i];
            }
        }
        return mostOccured;
    }
    public static int mode(int... var){
        int mostOccured = 0;
        int maxCount = 0;
        for (int i = 0; i < var.length; i++){
            int count = 0;
            for (int j = 0; j < var.length; j++){
                if (var[j] == var[i]){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                mostOccured = var[i];
            }
        }
        return mostOccured;
    }
    public static long mode(long... var){
        long mostOccured = 0;
        int maxCount = 0;
        for (int i = 0; i < var.length; i++){
            int count = 0;
            for (int j = 0; j < var.length; j++){
                if (var[j] == var[i]){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                mostOccured = var[i];
            }
        }
        return mostOccured;
    }
    //range
    public static float range(float... var){
        return max(var) - min(var);
    }
    public static double range(double... var){
        return max(var) - min(var);
    }
    public static int range(int... var){
        return max(var) - min(var);
    }
    public static long range(long... var){
        return max(var) - min(var);
    }
    //midRange
    public static float midRange(float... var){
        return (min(var)+max(var)/2);
    }
    public static double midRange(double... var){
        return (min(var)+max(var)/2);
    }
    public static int midRange(int... var){
        return (min(var)+max(var)/2);
    }
    public static long midRange(long... var){
        return (min(var)+max(var)/2);
    }
    //rectangleVolume
    public static float rectangleVolume(float length, float width, float height){
        return multiply(length, width, height);
    }
    public static double rectangleVolume(double length, double width, double height){
        return multiply(length, width, height);
    }
    public static int rectangleVolume(int length, int width, int height){
        return multiply(length, width, height);
    }
    public static long rectangleVolume(long length, long width, long height){
        return multiply(length, width, height);
    }

    public static double unitCircle(Unit inputUnit, Unit outPutUnit, double input){
        switch (outPutUnit){
            case RADIANS:
                switch (inputUnit){
                    case DEGREES:
                        return degToRad(input);
                    case MAGNATUDE_X:
                        return Math.asin(input);
                    case MAGNATUDE_Y:
                        return Math.acos(input);
                    case RADIANS:
                        return input;
                }
            case DEGREES:
                switch (inputUnit){
                    case DEGREES:
                        return input;
                    case MAGNATUDE_X:
                        return radToDeg(Math.asin(input));
                    case MAGNATUDE_Y:
                        return radToDeg(Math.acos(input));
                    case RADIANS:
                        return radToDeg(input);
                }
            case MAGNATUDE_X:
                switch (inputUnit) {
                    case DEGREES:
                        return radToDeg(Math.asin(input));
                    case RADIANS:
                        return Math.asin(input);
                }
            case MAGNATUDE_Y:
                switch (inputUnit){
                    case DEGREES:
                        return radToDeg(Math.acos(input));
                    case RADIANS:
                        return Math.acos(input);
                }
            default:
                return 0.0;
        }
    }
    public static double unitCircle(Unit inputUnit, Unit outPutUnit, Vector2 input){
        double xAngle = Math.asin(input.x);
        double yAngle = Math.acos(input.y);
        switch (inputUnit){
            case MAGNATUDE:
                switch (outPutUnit){
                    case RADIANS:
                        if (xAngle == yAngle){
                            return xAngle;
                        }else{
                            return 0.0;
                        }
                    case DEGREES:
                        if (xAngle == yAngle){
                            return radToDeg(xAngle);
                        }else{
                            return 0.0;
                        }
                    case MAGNATUDE_X:
                        return input.x;
                    case MAGNATUDE_Y:
                        return input.y;
                    case MAGNATUDE:
                    default:
                        return 0.0;
                }
            default:
                return 0.0;
        }
    }


    public static double closest (double var, double... input){
        return 0;
    }
    public static double farthest (double var, double... input){
        return 0;
    }
    //probablity - target outcomes/totaloutcomes
    public static double probablity(int numOfFavorableOutcomes, Object... sample){
        return (double) sample.length/numOfFavorableOutcomes;
    }
    //quadratic x = Ã¢Ë†â€™b Ã‚Â± Ã¢Ë†Å¡bÃ‚Â²-4ac/2a
    //vector2 distance d=Ã¢Ë†Å¡(xÃ¢â€šï¿½ Ã¢â‚¬â€œ xÃ¢â€šâ€š)Ã‚Â² + (yÃ¢â€šï¿½ Ã¢â‚¬â€œ yÃ¢â€šâ€š)Ã‚Â²
    public double vector2Distance (Vector2 v1, Vector2 v2){
        return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));

    }
    //Slope yÃ¢â€šâ€š Ã¢â‚¬â€œ yÃ¢â€šï¿½ / xÃ¢â€šâ€š Ã¢â‚¬â€œ xÃ¢â€šï¿½

    //slope intercept y=mx+b.
    //vector2 midpoint (xÃ¢â€šï¿½+xÃ¢â€šâ€š) / 2, (yÃ¢â€šï¿½+yÃ¢â€šâ€š) / 2        takes 2 vector 2 points and outputs a vector 2 point
    //triangle area a = 1/2 (5)(8) (base)(Hight)
    //Pythagorean Theorem: aÃ‚Â²+bÃ‚Â²=cÃ‚Â²
    //Area of Rectangle: area = length x width
    //Area of Circle: Ã�â‚¬ * rÃ‚Â²
    //The perimeter of Square = P = 4a Where Ã¢â‚¬ËœaÃ¢â‚¬â„¢ is the length of the sides of square
    //Perimeter of Rectangle = P = 2(l + b) Where Ã¢â‚¬ËœlÃ¢â‚¬â„¢ is Length and Ã¢â‚¬ËœbÃ¢â‚¬â„¢ is Breadth
    //The area of Square = A = a2 Where Ã¢â‚¬ËœaÃ¢â‚¬â„¢ is the length of the sides of a Square

    public static class Vector2{
        double x = 0;
        double y = 0;
        public Vector2(){
            this.x = 0;
            this.y = 0;
        }
        public Vector2(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    public static class Fraction{
        private int numerator;
        private int denominator;
        public Fraction() {
            numerator = 0;
            denominator = 1;
        }
        public Fraction(int num) {
            numerator = num;
            denominator = 1;
        }
        public Fraction(int num, int denom) {
            numerator = (denom < 0 ? -num : num);
            if (denom == 0) {
                denominator = 1;
            }
            denominator = (denom < 0 ? -denom : denom);
            reduce();
        }
        private void reduce() {
            int n = numerator, d = denominator, largest;
            if (numerator < 0) {
                n = -numerator;
            }
            if (n > d) {
                largest = n;
            }
            else {
                largest = d;
            }
            int gcd = 0;
            for (int i = largest; i >= 2; i--) {
                if (numerator % i == 0 && denominator % i == 0) {
                    gcd = i;
                    break;
                }
            }
            if (gcd != 0) {
                numerator /= gcd;
                denominator /= gcd;
            }
        }
    }
}

