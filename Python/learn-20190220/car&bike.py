class Vehicle:
    def __init__(self,speed):
        self.v = speed
    def drive(self,distance):
        time = distance/self.v
        print('need %f hr(s)'%time)

            
class Bike(Vehicle):
    pass

class Car(Vehicle):
    def __init__(self,speed,fuel):
        Vehicle.__init__(self,speed)
        self.f = fuel

    def drive(self,d):
        Vehicle.drive(self,d)
        print('need %f oils'%(d*self.f))

b = Bike(15.0)
c = Car(80.0, 0.012)
b.drive(100.0)
c.drive(100.0)
