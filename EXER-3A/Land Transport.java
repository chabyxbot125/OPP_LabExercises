
class LandTransport extends Transportation {
    int wheels;
}

class Truck extends LandTransport { double payloadCapacity; }
class SUV extends LandTransport { boolean hasOffRoadMode; }
class Tricycle extends LandTransport { boolean sidecarAttached; }
class Motorcycle extends LandTransport { boolean hasHelmetStorage; }
class Kariton extends LandTransport { String material; }
