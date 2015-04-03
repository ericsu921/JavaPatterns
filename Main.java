
// Data Type
abstract class SeasoningD {}

// Variant
class Salt extends SeasoningD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

// class Pepper extends SeasoningD {
//     public String toString() {
//         return "new " + getClass().getName() + "()";
//     }
// }

// Variant
class Thyme extends SeasoningD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

// Variant
class Sage extends SeasoningD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class PointD {
    int x;
    int y;

    PointD(int _x, int _y) {
        x = _x;
        y = _y;
    }
    // ----------------------------

    boolean closerTo0(PointD p) {
        return distanceTo0() <= p.distanceTo0();
    }

    abstract int distanceTo0();
}

// Variant
class CartesianPt extends PointD {
    CartesianPt(int _x, int _y) {
        super(_x, _y);
    }
    // ----------------------------

    int distanceTo0() {
        return (int)Math.sqrt((x * x) + (y * y));
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + x + ", " + y + ")";
    }
}

// Variant
class ManhattanPt extends PointD {
    ManhattanPt(int _x, int _y) {
        super(_x, _y);
    }
    // ----------------------------

    int distanceTo0() {
        return x + y;
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + x + ", " + y + ")";
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class NumD {}

// Terminator
class Zero extends NumD {
    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

// Variant
class OneMoreThan extends NumD {
    NumD predecessor;

    OneMoreThan(NumD _p) {
        predecessor = _p;
    }
    // -----------------------

    public String toString() {
        return "new " + getClass().getName() + "(\n " + predecessor + ")";
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class LayerD {}

// Variant
class Base extends LayerD {
    Object o;

    Base(Object _o) {
        o = _o;
    }
    // -----------------------

    public String toString() {
        return "new " + getClass().getName() + "(\n " + o + ")";
    }
}

// Variant
class Slice extends LayerD {
    LayerD l;

    Slice(LayerD _l) {
        l = _l;
    }
    // -----------------------

    public String toString() {
        return "new " + getClass().getName() + "(\n " + l + ")";
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class ShishD {
    NothingButOnionsV nboFn = new NothingButOnionsV();
    IsVegetarianV ivFn = new IsVegetarianV();

    abstract boolean nothingButOnions();
    abstract boolean isVegetarian();
    abstract public String toString();
}

// Terminator
class Skewer extends ShishD {
    boolean nothingButOnions() {
        return nboFn.forSkewer();
    }

    boolean isVegetarian() {
        return ivFn.forSkewer();
    }

    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}

// Variant
class Onion extends ShishD {
    ShishD s;

    Onion(ShishD _s) {
        s = _s;
    }
    // -----------------------

    boolean nothingButOnions() {
        return nboFn.forOnion(s);
    }

    boolean isVegetarian() {
        return ivFn.forOnion(s);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + s + " )";
    }
}

// Variant
class Lamb extends ShishD {
    ShishD s;

    Lamb(ShishD _s) {
        s = _s;
    }
    // -----------------------

    boolean nothingButOnions() {
        return nboFn.forLamb(s);
    }

    boolean isVegetarian() {
        return ivFn.forLamb(s);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + s + " )";
    }
}

// Variant
class Tomato extends ShishD {
    ShishD s;

    Tomato(ShishD _s) {
        s = _s;
    }
    // -----------------------

    boolean nothingButOnions() {
        return nboFn.forTomato(s);
    }

    boolean isVegetarian() {
        return ivFn.forTomato(s);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + s + " )";
    }
}

// ================================================== //

// Visitor Class
class NothingButOnionsV {
    boolean forSkewer() {
        return true;
    }

    boolean forOnion(ShishD s) {
        return s.nothingButOnions();
    }

    boolean forLamb(ShishD s) {
        return false;
    }

    boolean forTomato(ShishD s) {
        return false;
    }
}

// ================================================== //

// Visitor Class
class IsVegetarianV {
    boolean forSkewer() {
        return true;
    }

    boolean forOnion(ShishD s) {
        return s.isVegetarian();
    }

    boolean forLamb(ShishD s) {
        return false;
    }

    boolean forTomato(ShishD s) {
        return s.isVegetarian();
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class KebabD {
    abstract boolean isVeggie();
    abstract Object whatHolder();
}

// Terminator
class Holder extends KebabD {
    Object o;

    Holder(Object _o) {
        o = _o;
    }
    // -----------------------

    boolean isVeggie() {
        return true;
    }

    Object whatHolder() {
        return o;
    }
}

// Variant
class Shallot extends KebabD {
    KebabD k;

    Shallot(KebabD _k) {
        k = _k;
    }
    // -----------------------

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

// Variant
class Shrimp extends KebabD {
    KebabD k;

    Shrimp(KebabD _k) {
        k = _k;
    }
    // -----------------------

    boolean isVeggie() {
        return false;
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

// Variant
class Radish extends KebabD {
    KebabD k;

    Radish(KebabD _k) {
        k = _k;
    }
    // -----------------------
    
    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

// Variant
class Pepper extends KebabD {
    KebabD k;

    Pepper(KebabD _k) {
        k = _k;
    }
    // -----------------------

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

// Variant
class Zucchini extends KebabD {
    KebabD k;

    Zucchini(KebabD _k) {
        k = _k;
    }
    // -----------------------

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class RodD {}

// Variant
class Dagger extends RodD {}

// Variant
class Sabre extends RodD {}

// Variant
class Sword extends RodD {}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class PlateD {}

// Variant
class Gold extends PlateD {}

// Variant
class Silver extends PlateD {}

// Variant
class Brass extends PlateD {}

// Variant
class Copper extends PlateD {}

// Variant
class Wood extends PlateD {}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class PizzaD {
    // Visitor Objects
    RemoveAnchoviesV remFn = new RemoveAnchoviesV();
    TopAnchovyWithCheeseV topFn = new TopAnchovyWithCheeseV();
    SubstituteAnchovyByCheeseV subFn = new SubstituteAnchovyByCheeseV();

    abstract PizzaD removeAnchovies();
    abstract PizzaD topAnchovyWithCheese();
    abstract PizzaD substituteAnchovyByCheese();
}

// Terminator - Crust doesn't take in anything, so it must terminate on Crust
class Crust extends PizzaD {
    PizzaD removeAnchovies() {
        return remFn.forCrust();
    }

    PizzaD topAnchovyWithCheese() {
        return topFn.forCrust();
    }

    PizzaD substituteAnchovyByCheese() {
        return subFn.forCrust();
    }

    public String toString() {
        return "new " + getClass().getName() + "()";
    }
}   

// Variant
class Cheese extends PizzaD {
    PizzaD p;
    Cheese(PizzaD _p) {
        p = _p;
    }
    // -----------------------

    PizzaD removeAnchovies() {
        return remFn.forCheese(p);
    }

    PizzaD topAnchovyWithCheese() {
        return topFn.forCheese(p);
    }

    PizzaD substituteAnchovyByCheese() {
        return subFn.forCheese(p);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + p + ")";
    }
}

// Variant
class Olive extends PizzaD {
    PizzaD p;
    Olive(PizzaD _p) {
        p = _p;
    }
    // -----------------------

    PizzaD removeAnchovies() {
        return remFn.forOlive(p);
    }

    PizzaD topAnchovyWithCheese() {
        return topFn.forOlive(p);
    }

    PizzaD substituteAnchovyByCheese() {
        return subFn.forOlive(p);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + p + ")";
    }
}

// Variant
class Anchovy extends PizzaD {
    PizzaD p;
    Anchovy(PizzaD _p) {
        p = _p;
    }
    // -----------------------

    PizzaD removeAnchovies() {
        return remFn.forAnchovy(p);
    }

    PizzaD topAnchovyWithCheese() {
        return topFn.forAnchovy(p);
    }

    PizzaD substituteAnchovyByCheese() {
        return subFn.forAnchovy(p);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + p + ")";
    }
}

// Variant
class Sausage extends PizzaD {
    PizzaD p;
    Sausage(PizzaD _p) {
        p = _p;
    }
    // -----------------------

    PizzaD removeAnchovies() {
        return remFn.forSausage(p);
    }

    PizzaD topAnchovyWithCheese() {
        return topFn.forSausage(p);
    }

    PizzaD substituteAnchovyByCheese() {
        return subFn.forSausage(p);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + p + ")";
    }
}

// Variant
class Spinach extends PizzaD {
    PizzaD p;

    Spinach(PizzaD _p) {
        p = _p;
    }
    // -----------------------

    PizzaD removeAnchovies() {
        return remFn.forSpinach(p);
    }

    PizzaD topAnchovyWithCheese() {
        return topFn.forSpinach(p);
    }

    PizzaD substituteAnchovyByCheese() {
        return subFn.forSpinach(p);
    }

    public String toString() {
        return "new " + getClass().getName() + "(\n " + p + ")";
    }
}

// ================================================== //

// Visitor Class
class RemoveAnchoviesV {
    PizzaD forCrust() {
        return new Crust();
    }

    PizzaD forCheese(PizzaD p) {
        return new Cheese(p.removeAnchovies());
    }

    PizzaD forOlive(PizzaD p) {
        return new Olive(p.removeAnchovies());
    }

    PizzaD forAnchovy(PizzaD p) {
        return p.removeAnchovies();
    }

    PizzaD forSausage(PizzaD p) {
        return new Sausage(p.removeAnchovies());
    }

    PizzaD forSpinach(PizzaD p) {
        return new Spinach(p.removeAnchovies());
    }
}

// ================================================== //

// Visitor Class
class TopAnchovyWithCheeseV {
    PizzaD forCrust() {
        return new Crust();
    }

    PizzaD forCheese(PizzaD p) {
        return new Cheese(p.topAnchovyWithCheese());
    }

    PizzaD forOlive(PizzaD p) {
        return new Olive(p.topAnchovyWithCheese());
    }

    PizzaD forAnchovy(PizzaD p) {
        return new Cheese(new Anchovy(p.topAnchovyWithCheese()));
    }

    PizzaD forSausage(PizzaD p) {
        return new Sausage(p.topAnchovyWithCheese());
    }

    PizzaD forSpinach(PizzaD p) {
        return new Spinach(p.topAnchovyWithCheese());
    }
}

// ================================================== //

// Visitor Class
class SubstituteAnchovyByCheeseV {
    PizzaD forCrust() {
        return new Crust();
    }

    PizzaD forCheese(PizzaD p) {
        return new Cheese(p.substituteAnchovyByCheese());
    }

    PizzaD forOlive(PizzaD p) {
        return new Olive(p.substituteAnchovyByCheese());
    }

    PizzaD forAnchovy(PizzaD p) {
        return new Cheese(p.substituteAnchovyByCheese());
    }

    PizzaD forSausage(PizzaD p) {
        return new Sausage(p.substituteAnchovyByCheese());
    }

    PizzaD forSpinach(PizzaD p) {
        return new Spinach(p.substituteAnchovyByCheese());
    }
}

// ================================================== //
//                                                    //
// ================================================== //

// Data Type
abstract class PizzaPieD {}

// Terminator
class Bottom extends PizzaPieD {}

// Variant
class Topping extends PizzaPieD {
    Object t;
    PizzaPieD r;

    Topping(Object _t, PizzaPieD _r) {
        t = _t;
        r = _r;
    }
}

// ================================================== //
//                                                    //
// ================================================== //

abstract class FishD {}

class Anchovy extends FishD {}

class Salmon extends FishD {}

class Tuna extends FishD {}

// ================================================== //
//                                                    //
// ================================================== //

class Main {
    public static void main (String args[]) {
        PizzaD x = 
            new Anchovy(
                new Cheese(
                    new Spinach(
                        new Crust())));
        System.out.println("\n" + x);
        System.out.println("\nremoveAnchovies: " + x.removeAnchovies());
        System.out.println("\ntopAnchovyWithCheese: " + x.topAnchovyWithCheese());
        System.out.println("\nsubstituteAnchovyByCheese: " + x.substituteAnchovyByCheese());

        PizzaD y = 
            new Anchovy(
                new Anchovy(
                    new Anchovy(
                        new Crust())));
        System.out.println("\n" + y);
        System.out.println("\nremoveAnchovies: " + y.removeAnchovies());
        System.out.println("\ntopAnchovyWithCheese: " + y.topAnchovyWithCheese());
        System.out.println("\nsubstituteAnchovyByCheese: " + y.substituteAnchovyByCheese());

        PizzaD z = 
            new Sausage(
                new Spinach(
                    new Cheese(
                        new Crust())));
        System.out.println("\n" + z);
        System.out.println("\nremoveAnchovies: " + z.removeAnchovies());
        System.out.println("\ntopAnchovyWithCheese: " + z.topAnchovyWithCheese());
        System.out.println("\nsubstituteAnchovyByCheese: " + z.substituteAnchovyByCheese());
    }
}