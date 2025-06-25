def torusSurfaceArea(majorRadius, minorRadius):
    #Computes the Surface Area of torus
    surfaceArea=(2*3.1416*majorRadius)*(2*3.1416*minorRadius)
    return surfaceArea

def torusVolume(majorRadius, minorRadius):
    #Computes the Volume of torus
    volume=(2*3.1416*majorRadius)*(3.1416*(minorRadius**2))
    return volume

def userChoice():

    print("Torus Calculator")
    print("1. Compute Surface Area")
    print("2. Compute Volume")

    formulaChosen = int(input("Select an option (1-2):"))

    if formulaChosen>2 or formulaChosen<1:
        print("Please select between 1 and 2.")
        return userChoice()

    majorRadius=int(input("Enter the major radius (R):"))
    minorRadius=int(input("Enter the minor radius (r):"))

    #Conditions
    if (majorRadius and minorRadius) <= 0:
        print("Both radii must be greater than zero. Please try again.")
        return userChoice()
    
    if minorRadius > majorRadius:
        print("Minor radius (r) must be less than Major radius (R). Please try again.")
        return userChoice()
    
    if formulaChosen == 1:
        print(f"Surface area of torus: {torusSurfaceArea(majorRadius, minorRadius)}")

    else:
        print(f"Volume of torus: {torusVolume(majorRadius, minorRadius)}")
    
    #Asks user to compute again or not
    userRepeat = str(input("Do you want to computer another set? (yes/no): "))
    if userRepeat == "yes":
        return userChoice()
    else:
        print("Exiting program. Goodbye!")
        exit()
    
userChoice()