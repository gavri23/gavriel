
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
        
        City cityToAdd = new City(cityName, xCenter, yCenter, xStation, yStation, numOfResidents, noOfNeighborhoods);
        CityNode cityToAddNode = new CityNode(cityToAdd);
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
        // BUG!!! cityPtr.getNext() is null... condition will throw Nill Point Exception (maybe try kiiping the last City that is not null)
        if(cityPtr.getCity().getCityName().equals(cityName)) //if the last city equals to the city we want to add
        {
            return false;
        }     
        cityPtr.setNext(cityToAddNode);
        return true; 
    }
        
        
        
         
          
       
    

    public long getNumOfResidents()
    {
        long sumOfResidents = 0;
        CityNode temp = _head;
        while(temp != null)
        {
            sumOfResidents += temp.getCity().getNumOfResidents();
            temp = temp.getNext();
        }
        return sumOfResidents;
    }

    public double longestDistance()
    {
        CityNode temp1 = _head;
        
        int numOfCities;
        double maxDistance = 0;
        if(temp1 == null)
        {
            return maxDistance;
        }
        while(temp1 != null)
        {
            // BUG!!! need to rest temp2 here
            CityNode temp2 = _head.getNext();
            if(temp2 == null){
                return maxDistance;
            }
            while(temp2 != null)
            {
                if(maxDistance < temp1.getCity().getCityCenter().distance(temp2.getCity().getCityCenter()))
                {
                    maxDistance = temp1.getCity().getCityCenter().distance(temp2.getCity().getCityCenter());
                }
                temp2 = temp2.getNext();
            }
            temp1 = temp1.getNext();

        }
        return maxDistance;
    }

    public String citiesNorthOf(String cityName)
    {
        
        CityNode currentCity = getCityNode(cityName); //a variable that gets the city with all her details
        String listOfNorthenCities = "";//a variable that is a list that holds the cities that are norther
        if(currentCity == null)
        {
            return "There is no city with the name" + currentCity;
        }
        
        CityNode temp = _head;
        while(temp != null)
        {
            if(currentCity.getCity().getCityCenter().isUnder(temp.getCity().getCityCenter()))
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
        return "The city north of " + currentCity.getCity().getCityName() + " are:\n" + listOfNorthenCities;//the final list with the norther cities
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
            if(temp.getCity().getCityCenter().isAbove(temp.getNext().getCity().getCityCenter()))
            {
                southestCity = temp.getNext();
            }
            temp = temp.getNext();
        }
        return southestCity.getCity();
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
    CityNode newPtr = _head;
    if(_head == null){
        copyOfCountry = null;
        return copyOfCountry;
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
    while(findCity != null &&(!findCity.getCity().getCityName().equals(cityName))){
        
          findCity = findCity.getNext();  
            }         
    return findCity;       
    
    } 
    
     
       
    
  
    
  public City unifyCities(String cityName1,String cityName2){
    String unitedCity = cityName1 +"-" + cityName2;//the new name of the united city
    CityNode ptrC1 = getCityNode(cityName1);//finds the first CityNode
    CityNode ptrC2 = getCityNode(cityName2);//finds the second CityNode
    City city1 = new City(ptrC1.getCity());
    City city2 = new City(ptrC2.getCity());
    long newNumOfResidents = city1.getNumOfResidents() + city2.getNumOfResidents();//the number of residents in the united city
    int newNumOfNeighborhoods = city1.getNoOfNeighborhoods() + city2.getNoOfNeighborhoods();//the number of neighborhoods in the united city
    double newCityCenterX = (city1.getCityCenter().getX() + city2.getCityCenter().getX())/2;//the x coordinate of the new center of the united city
    double newCityCenterY = (city1.getCityCenter().getY() + city2.getCityCenter().getY())/2;//the y coordinate of the new center of the united city
    Point newCityStation;//a variable that gets the point of the new central station of the united city
    if(city1.getCentralStation().isLeft(city2.getCentralStation())){
    
        newCityStation = new Point(city1.getCentralStation());
    }
    else{
        newCityStation = new Point(city2.getCentralStation());
    }
    City newCity = new City(unitedCity,newCityCenterX,newCityCenterY,newCityStation.getX(),newCityStation.getY(),newNumOfResidents,newNumOfNeighborhoods);
     // the united city and her new details   
    CityNode unitedCityNode = new CityNode(newCity);//creating the united city as a node 
    
    
    
    if(city1.getNumOfResidents()>=city2.getNumOfResidents()){
       ptrC1.setCity(newCity);
       if(ptrC2==_head){
           _head = ptrC2.getNext();
        }
       else{
       CityNode ptrDeleteCity2 = _head;
       while(ptrDeleteCity2.getNext()!=ptrC2){
           ptrDeleteCity2 = ptrDeleteCity2.getNext();
        
        }
       ptrDeleteCity2.setNext(ptrC2.getNext()); 
        }     
       }    
      else{
      
          ptrC2.setCity(newCity);
       if(ptrC1==_head){
           _head = ptrC1.getNext();
        }
       else{
       CityNode ptrDeleteCity1 = _head;
       while(ptrDeleteCity1.getNext()!=ptrC1){
           ptrDeleteCity1 = ptrDeleteCity1.getNext();
        
        }
       ptrDeleteCity1.setNext(ptrC1.getNext()); 
        }     
       }
        return newCity;
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
     
     
     public static void main (String[] args)
    {

        System.out.println("\n-----Testing CityNode Class:-----\n"); 

        City city1= new City ("Rehovot", 37, 39, 36, 38, 1200, 31);
        CityNode cityNode1=new CityNode(city1);

        City city2= new City ("Eilat", 0, 0, 36, 38, 120, 31);
        CityNode cityNode2=new CityNode(city2,null);

        City city3= new City ("Rehovot", 37, 39, 36, 38, 1200, 31);
        City city4= new City ("Tel-Aviv", 37, 39, 36, 38, 1000, 31);

        CityNode cityNode6=new CityNode(city4,null);
        CityNode cityNode7=new CityNode(city3,cityNode6);

        City city8= new City ("Jerusalem", 37, 39, 36, 38, 1200, 31);
        CityNode cityNode9=new CityNode(city8,null);
        CityNode cityNode10=new CityNode(cityNode9);

        City city15= new City ("Rehovot", 37, 39, 36, 38, 1200, 31);  
        CityNode cityNode15=new CityNode(city15);
        City city16=cityNode15.getCity();

        City city17= new City ("Rehovot", 37, 39, 36, 38, 1200, 31); 
        City city18= new City ("Tel-Aviv", 37, 39, 36, 38, 1200, 31);
        CityNode cityNode17=new CityNode(city17);
        CityNode cityNode18=new CityNode(city18,cityNode17);
        CityNode cityNode19=cityNode18.getNext();

        City city20= new City ("Rehovot", 37, 39, 36, 38, 1200, 31);  
        CityNode cityNode20=new CityNode(city20);
        City city21= new City ("Jerusalem", 37, 39, 36, 38, 1200, 31);
        cityNode20.setCity(city21);
        City city22= new City ("Rehovot", 37, 39, 36, 38, 1200, 31);  
        CityNode cityNode22=new CityNode(city22);
        cityNode20.setNext(cityNode22);

        //-----------------------Country---------------------
        System.out.println("\n-----Testing Country Class:-----\n"); 
        city1= new City ("Rehovot", 37, 39, 36, 38, 1200, 31);

        Country country1 = new Country ("Israel");
        //Test getCountryName    
        System.out.println("\nTesting getCountryName");
        String name = country1.getCountryName();

        System.out.println("Country name is: "+name);

        boolean success;
        System.out.println("\nTesting adding one city");
        //add one city

        success= country1.addCity("Jerusalem", 20, 30, 25, 35, 850, 3);
        if(success == false)  
            System.out.println("Error in addcity: failed to add one city to an empty list.");
        System.out.println("\nTesting toString after adding 2 more  cities - order of cities unimportant");
        //Test toString()
        country1.addCity("Tel-Aviv", 60, 70, 65, 75, 640, 6);
        country1.addCity("Beer Sheva", 10, 20, 15, 25, 920, 8);
        System.out.println(country1);

        //test getNumOfResidents()
        System.out.println("\nTesting getNumOfResidents");
        country1 = new Country("Israel");
        country1.addCity("Beer Sheva", 0, 0, 0, 0, 900, 8);
        country1.addCity("Jerusalem", 20, 20, 20, 20, 800, 8);
        country1.addCity("Tel-Aviv", 50, 10, 50, 10, 700, 6);
        country1.addCity("Eilat", 300, 400, 300, 400, 600, 8);         
        long numOfResidents = country1.getNumOfResidents();

        System.out.println("NumOfResidents: "+numOfResidents);

        //test longestDistance()
        System.out.println("\nTesting longestDistance");
        country1 = new Country("Israel");
        country1.addCity("Beer Sheva", 0, 0, 0, 0, 920, 8);

        country1.addCity("Eilat", 300, 400, 300, 400, 922, 8);  
        double longestDistance = country1.longestDistance();
        System.out.println("LongestDistance: "+longestDistance);

        //test citiesNorthOf
        System.out.println("\nTesting citiesNorthOf - order of cities unimportant");
        country1 = new Country ("Israel");  
        country1.addCity("Tel-Aviv1", 1, 1, 1, 1, 610, 6);
        country1.addCity("Tel-Aviv2", 2, 2, 2, 2, 641, 13);
        country1.addCity("Tel-Aviv3", 3, 3, 3, 3, 642, 23);
        country1.addCity("Tel-Aviv4", 4, 4, 4, 4, 682, 11);

        System.out.println("Cities north of Tel-Aviv2:\n" + country1.citiesNorthOf(new String("Tel-Aviv2")));
        //test southernmostCity
        System.out.println("\nTesting southernmostCity");
        country1 = new Country ("Israel");
        country1.addCity("Tel-Aviv", 50, 10, 50, 10, 640, 6);
        country1.addCity("Beer Sheva", 2, 2, 2, 2, 920, 8);
        country1.addCity("Jerusalem", 20, 20, 20, 20, 922, 8);

        System.out.println("Southernmost city:\n" + country1.southernmostCity());

        //Test getNumOfCities
        System.out.println("\nTesting getNumOfCities");
        country1 = new Country("Israel");
        country1.addCity("Tel-Aviv", 60, 70, 65, 75, 640, 6);
        country1.addCity("Beer Sheva", 10, 20, 15, 25, 920, 8);
        country1.addCity("Eilat", 13, 27, 12, 21, 922, 8);

        System.out.println("Number of cities:"+country1.getNumOfCities());

        //test unifyCities
        System.out.println("\nTesting unifyCities");         
        country1 = new Country ("Israel");  
        String name1= new String("Jerusalem"), name2 =new String( "Tel-Aviv"), name3= new String("Beer Sheva"), name4=new String( "Haifa");
        country1.addCity(name1, 60, 60, 60, 60, 642, 6);
        country1.addCity(name2, 70, 70, 70, 70, 641, 6);
        country1.addCity(name3, 80, 80, 80, 80, 940, 6);
        country1.addCity(name4, 90, 90, 90, 90, 642, 6);  
        System.out.println("\nCountry before unification:\n"+country1);
        City uniCity = country1.unifyCities(new String("Jerusalem"),new String("Beer Sheva"));
        System.out.println("\nUnified cities now one city: \n"+uniCity);
        System.out.println("\ncountry1 after unifying cities: Jerusalem-Beer Sheva should be where Beer Sheva was\n"+country1);
        //Test getCities:
        System.out.println("\nTesting getCities");
        country1 = new Country ("Israel");  
        country1.addCity("Jerusalem", 10, 10, 60, 60, 640, 6);
        country1.addCity("Tel-Aviv", 70, 70, 70, 70, 641, 6);
        country1.addCity("Beer Sheva", 80, 80, 80, 80, 642, 6);

        Country country1Copy= country1.getCities();   

        System.out.println("original:  - order of cities unimportant\n");
        System.out.println(country1);
        System.out.println("\ncopy:  - order of cities unimportant\n");
        System.out.println(country1Copy);
    }
}   





