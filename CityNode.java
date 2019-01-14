
/**
 * Write a description of class CityNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CityNode
{
    // instance variables - replace the example below with your own
    private City _city;
    private CityNode _next;
    /**
     * Constructor for objects of class CityNode
     */
    public CityNode(City c)
    {
        _city = c;
        _next = null;
    }
    public CityNode(City c, CityNode n)
    {
        _city = c;
        _next = n;
    }
    public CityNode (CityNode c)
    {
        _next = c;

    }
    public City getCity()
    {
        return _city;
    }
    public CityNode getNext()
    {
        return _next;
    }
    public void setCity (City c)
    {
        _city = c;
    }
    public void setNext( CityNode next)
    {
        _next = next;
    }
}








