
/**
 * Write a description of class Country here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Country
{
    // instance variables - replace the example below with your own
    private CityNode _head;
    private String _countryName;


    /**
     * Constructor for objects of class Country1
     */
    public Country(String CountryName)
    {
        // initialise instance variables
        _countryName = CountryName;
        _head = null;

    }
    public int getNumOfCities()
    {
        CityNode temp = _head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
    /**
        WHERE IS TIUD????
     */
    public boolean addCity(String cityName, double xCenter, double yCenter, double xStation, double yStation, long numOfResidents, int noOfNeighborhoods)
    {
        // put your code here
        /*
         if(city is already in the list){
             return false;
                   }
            */
        City cityToAdd = new City(cityName, xCenter, yCenter, xStation, yStation, numOfResidents, noOfNeighborhoods);
        CityNode cityToAddNode = new CityNode(cityToAdd);
        cityToAddNode.setCity(cityToAdd); // why not use constructor with City?

        if(_head == null)
        {
            _head = cityToAddNode;
            return true;
        }
        CityNode cityPtr = _head;
        while(cityPtr.getNext() != null)
        {
            if(cityPtr.getCity().getCityName().equals(cityName))
            {
                return false;
            }
            cityPtr = cityPtr.getNext();
        }

        // BUG!!! cityPtr is null... condition will throw Nill Point Exception (maybe try kiiping the last City that is not null)
        if(cityPtr.getCity().getCityName().equals(cityName)) //if the last city equals to the city we want to add
        {
            return false;
        }

        cityPtr.setNext() = cityToAddNode;
        return true;
    }

    public long getNumOfResidents()
    {
        long sumOfResidents = 0;
        CityNode temp = _head;
        while(temp != null)
        {
            sumOfResidents += temp.getNumOfResidents();
            temp = temp.getNext();
        }
        return sumOfResidents;
    }

    public double longestDistance()
    {
        CityNode temp1 = _head;
        
        int numOfCities;
        double maxDistance = 0;
        if(getNumOfCities(numOfCities) < 2)
        {
            return maxDistance;
        }
        while(temp1 != null)
        {
            // BUG!!! need to rest temp2 here
            CityNode temp2 = _head.getNext();
            while(temp2 != null)
            {
                if(maxDistance < temp1.getCityCenter().distance(temp2.getCityCenter()))
                {
                    maxDistance = temp1.getCityCenter().distance(temp2.getCityCenter());
                }
                temp2 = temp2.getNext();
            }
            temp1 = temp1.getNext();

        }
        return maxDistance;
    }

    public String citiesNorthOf(String cityName)
    {
        CityNode behind = null;
        CityNode currentCity = _head; //a variable that gets the city with all her details
        String listOfNorthenCities = "";//a variable that is a list that holds the cities that are norther
        while(currentCity != null)
        {
            if(behind.getCityName().getNext().equals(cityName))
            {
                currentCity = currentCity;
            }
            behind.getNext();
            currentCity.getNext();
        }
        if(currentCity == null)
        {
            return "There is no city with the name" + currentCity;
        }
        CityNode temp = _head;
        while(temp != null)
        {
            if(currentCity.getCityCenter().isUnder(temp.getCityCenter()))
            {
                
                
                listOfNorthenCities +="\n" + temp.toString() + "\n";
            }
            temp = temp.getNext();
        }
        //if the city we want to check is the northest in the Country so:
        if(listOfNorthenCities == "")
        {
            return "There is no cities north of" + currentCity;
        }
        return "The city north of " + currentCity.getCityName() + " are:\n" + listOfNorthenCities;//the final list with the norther cities
    }

    public City southernmostCity()
    {
        CityNode temp = _head;
        CityNode southestCity = _head;
        if(temp == null)
        {
            return null;
        }
        while(temp != null)
        {
            // maybe BUG. what if next is null???
            if(temp.getCityCenter().isAbove(temp.getNext()))
            {
                southestCity = temp.getNext();
            }
            temp = temp.getNext();
        }
        return southestCity;
    }
    public String getCountryName(){
    
        return _countryName;
    
    }
    private boolean addCity(City newCityToAdd){
    
        CityNode newCityAddNode = new CityNode(newCityToAdd);
        
    if(_head == null){
        _head = newCityAddNode;
        }
    CityNode temp = _head;
    while(temp.getNext()!=null){
    
        temp = temp.getNext();
    
    }
    
    temp.setNext(newCityAddNode);
    return true;
    }
    
    public Country getCities(){//need to write
    
    Country copyOfCountry = new Country (_countryName);
    City copyOfCity = new City(copyOfCity);
    CityNode copyOfCityNode = new CityNode(copyOfCity);
    copyOfCityNode.setCity(copyOfCity);
    
   
    CityNode newPtr = new CityNode (_head);
    if(_head == null){
        copyOfCountry = null;
    }
    while(newPtr != null){
         copyOfCountry.addCity(new City(newPtr.getCity()));
         
         newPtr=newPtr.getNext();
      }
    return copyOfCountry;     
    }     
    
    
    
    
    
    private CityNode getCityNode(String cityName) {
    CityNode findCity =  _head;
    
    if(findCity == null){
        return null;
    }
    while(findCity != null){
        if(findCity.getCityName().equals(cityName)){
             findCity = findCity;
            }
          findCity = findCity.getNext();  
            }         
    return findCity;       
    
    } 
    
     
       
    
  
    
    public City unifyCities(String cityName1,String cityName2){//need to write
    String unitedCity = cityName1 +"-" + cityName2;//the new name of the united city
    CityNode c1 = getCityNode(cityName1);//finds the first City
    CityNode c2 = getCityNode(cityName2);//finds the second City
    long newNumOfResidents = c1.getNumOfResidents() + c2.getNumOfResidents();//the number of residents in the united city
    int newNumOfNeighborhoods = c1.getNoOfNeighborhoods() + c2.getNoOfNeighborhoods();//the number of neighborhoods in the united city
    double newCityCenterX = (c1.getCityCenter().getX() + c2.getCityCenter().getX())/2;//the x coordinate of the new center of the united city
    double newCityCenterY = (c1.getCityCenter().getY() + c2.getCityCenter().getY())/2;//the y coordinate of the new center of the united city
    Point newCityStation;//a variable that gets the point of the new central station of the united city

    if(c1.getCentralStation().isLeft(c2.getCentralStation())){
    
        newCityStation = new Point(c1.getCentralStation());
    }
    else{
        newCityStation = new Point(c2.getCentralStation());
    }
    City newCity = new City(unitedCity,newCityCenterX,newCityCenterY,newCityStation.getX(),newCityStation.getY(),newNumOfResidents,newNumOfNeighborhoods);
     // the united city and her new details   
    CityNode unitedCityNode = new CityNode(newCity); 
    
    City city1 = new City(c1.get
    if(c1.getNumOfResidents()>=c2.getNumOfResidents()){
    
    
    
    
    }
        
        
        
        
    
    }
    
    public String toString(){
    CityNode cityPtr = _head;
     
        if(cityPtr==null){

    return "There are no cities in this country";
    }

    String listCountryCities = "";// a variable that holds the details of the cities
    
    while(cityPtr!=null){
        listCountryCities += "\n" + cityPtr.toString() + "\n";//adds to the variable the detail of the city
        cityPtr.getNext();
       
    }

    return "Cities of myCountry: \n" + listCountryCities;
     }
  
    }


