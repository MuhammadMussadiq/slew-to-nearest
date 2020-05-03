**Slew To Nearest**

It is just an assignment and below is the requirement given:

- Application shall provide user an interface to create a Camera Object. ( Camera Name, Camera Type (Front, Back, EO, IR, 360) , Latitude, Longitude, Azimuth (or Bearing))

- User shall be able to save or update the Camera object.
- Application shall provide user an interface to enter N points.( Latitude-Longitude)
- Application shall provide user a slew to nearest functionality.
  
  **Note :** Slew To Nearest functionality will get the camera position and the N number of points, and will make the calculation (Cartesian) for nearest point to camera,  and returns the nearest point.
             And Updates the cameras heading or azimuth value to that point. (Mimicking that camera is turning his face to that point)
- User shall be visually informed with the result of “Slew to Nearest’ function or an exception.


**To run the application**
- run command `mvn clean install`
- `java -jar path/to/jar/file`