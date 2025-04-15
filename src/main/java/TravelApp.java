import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String selected = "";
        TravelService travelService = new TravelService();

        System.out.println("관광 명소 검색 프로그램");
        while (true){
            System.out.println("=======================");
            System.out.println();
            System.out.println("1. 전체 목록");
            System.out.println("2. 권역별 관광지 목록");
            System.out.println("3. 키워드 검색");
            System.out.println("4. 종료");
            System.out.println();
            System.out.println("=======================");
            System.out.print("메뉴를 입력하세요: ");

            selected = sc.nextLine();

            switch (selected){
                case "1":
                    System.out.println();
                    System.out.println("전체 목록");
                    System.out.println();
                    travelService.getAllTravels();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("권역별 관광지 목록");
                    System.out.println();

                    //목록 가져와서 출력
                    String[] districts = travelService.getDistricts();

                    while(true){
                        for(int i = 0; i < districts.length; i++){
                            System.out.println(i+1 + ". " + districts[i]);
                        }
                        System.out.print("권역을 입력하세요: ");
                        int subSelected = Integer.parseInt(sc.nextLine());

                        if(subSelected > districts.length || subSelected < 0){
                            System.out.println("잘못된 값을 입력하셨습니다.");
                            System.out.println("유효한 입력값: 1~"+(districts.length));
                            System.out.println();
                        }else{
                            travelService.getTravelsByDistrict(subSelected-1); //선택한 번호는 인덱스값 +1이므로 빼주어야 함
                            break;
                        }
                    }
                    break;
                case "3":
                    System.out.println();
                    System.out.print("키워드 검색: ");
                    String searchWord = sc.nextLine();
                    travelService.getTravelsByKeyword(searchWord);
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다.");
                    System.out.println("유효한 입력값: 1~4");
                    System.out.println();
            }
        }







//        BufferedReader br = null;
//        String url = "jdbc:mysql://localhost:3306/travel_db";
//        String user = "root";
//        String password = "1234";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        CSVReader csvReader = null;
//
//        try {
//            csvReader = new CSVReaderBuilder( new FileReader( "travel.csv")).build();
//            System.out.println("파일 로딩 성공");
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("드라이버 로딩 성공");
//
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("데이터베이스 연결 성공");
//            String sql = String.format("insert into travel values(?,?,?,?,?,?)");
//            pstmt = conn.prepareStatement(sql);
//
//            List<String[]> lines = csvReader.readAll();
//            lines.remove(0);
//            for(int i=1; i<lines.size(); i++) {
//
//            }
//            for (String[] line : lines) {
//                pstmt.setInt(1, Integer.parseInt(line[0]));
//                pstmt.setString(2, line[1]);
//                pstmt.setString(3, line[2]);
//                pstmt.setString(4, line[3]);
//                pstmt.setString(5, line[4]);
//                pstmt.setString(6, line[5]);
//                pstmt.executeUpdate();
//                System.out.println("실행 성공");
//            }
//
//
//        } catch (FileNotFoundException e) {
//            System.out.println("에러: "+e.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.out.println("에러: "+e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("에러: "+e.getMessage());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (CsvException e) {
//            throw new RuntimeException(e);
//        } finally {
//        }

    }
}
