import java.util.List;

public class TravelService {
    private TravelDAO travelDAO;
    private String[] districts = {"수도권","충청권","전라권","경상권","강원권","제주권"};

    public TravelService() {
        travelDAO = new TravelDAO();
    }

    public String[] getDistricts() {
        return districts;
    }

    public void getAllTravels(){
        List<TravelVO> travelList = travelDAO.findTravels(null,null);
        if(travelList != null){
            for(TravelVO travel : travelList){
                System.out.println(travel);
            }
        }
    }
    public void getTravelsByDistrict(int district){
        List<TravelVO> travelList = travelDAO.findTravels("district", districts[district]);
        if(travelList != null){
            for(TravelVO travel : travelList){
                System.out.println(travel);
            }
        }
    }

    public void getTravelsByKeyword(String searchKeyword){
        List<TravelVO> travelList = travelDAO.findTravels("keyword",searchKeyword);
        if(travelList != null){
            for(TravelVO travel : travelList){
                System.out.println(travel);
            }
        }else{
            System.out.println("일치하는 키워드가 없습니다.");
        }
    }
}
