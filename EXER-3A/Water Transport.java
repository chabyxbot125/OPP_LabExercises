// WaterTransport.java
class WaterTransport extends Transportation {
    String hullType;
}

class Ship extends WaterTransport { double displacement; }
class Submarine extends WaterTransport { double maxDepth; }
