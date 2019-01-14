
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
    public Country1(String CountryName)
    {
        // initialise instance variables
        _countryName = CountryName;
        _head = null;

    }
    private int getNumOfCities()
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
        CityNode cityToAddNode = new CityNode();
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
        CityNode temp2 = _head.getNext();
        int numOfCities;
        double maxDistance = 0;
        if(getNumOfCities(numOfCities) < 2)
        {
            return maxDistance;
        }
        while(temp1 != null)
        {
            // BUG!!! need to rest temp2 here
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
                // why 2 new line????
                listOfNorthenCities += "\n";
                listOfNorthenCities += temp.toString() + "\n";
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
}

