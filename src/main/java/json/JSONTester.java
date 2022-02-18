package json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JSONTester {
    //public static final int ARRAY_SIZE=4;
    public static final String JSON_CAR_URL = "https://data.gov.il/api/3/action/datastore_search?resource_id=053cea08-09bc-40ec-8f7a-156f0677aff3&q=";
    public static final String JSON_BIKE_URL = "https://data.gov.il/api/3/action/datastore_search?resource_id=bf9df4e2-d90d-4c0a-a400-19e15af8e95f&q=";
    public static final String JSON_HEAVY_URL = "https://data.gov.il/api/3/action/datastore_search?resource_id=cd3acc5c-03c3-4c89-9c54-d40f93c0d790&q=";
    public static final String JSON_HANDICAPPED_URL = "https://data.gov.il/api/3/action/datastore_search?resource_id=c8b9f9c8-4612-4068-934f-d4acd2e3c06e&q=";
    public static final String JSON_RECALL_URL="https://data.gov.il/api/3/action/datastore_search?resource_id=36bf1404-0be4-49d2-82dc-2f1ead4a8b93&q=";
    public static void main(String[] args) {
        JSONTester tester = new JSONTester();
        Scanner scanner = new Scanner(System.in);
        String plateNumber;

        System.out.println("Please enter a plate number");
        plateNumber = scanner.nextLine();
        tester.readCarJSON(tester.getURLdata(JSON_CAR_URL + plateNumber));
        tester.readBikeJSON(tester.getURLdata(JSON_BIKE_URL + plateNumber));
        tester.readHeavyJSON(tester.getURLdata(JSON_HEAVY_URL+plateNumber));
        System.out.println((tester.isHandicapped(tester.getURLdata(JSON_HANDICAPPED_URL+plateNumber))?
                "not ":"")+"handicapped");
        //System.out.println((tester.isRecalled(tester.getURLdata(JSON_RECALL_URL+plateNumber))?
        //        "not ":"")+"recalled");
    }
    private boolean isRecalled(String myJson){
        try {
            var recall=new JSONObject(myJson);
            var result=recall.getJSONObject("result");
            var recallArray=recall.getJSONArray("records");
            return recallArray.length()==0;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isHandicapped(String myJson){
        try {
            var handicapped=new JSONObject(myJson);
            var result=handicapped.getJSONObject("result");
            var handicappedArray=result.getJSONArray("records");
            return handicappedArray.length()==0;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void readHeavyJSON(String myJson){
        try {
            var heavyData=new JSONObject(myJson);
            var result=heavyData.getJSONObject("result");
            var heavyArray=result.getJSONArray("records");
            if ((heavyArray.length()==0)){
                //System.out.println("heavy vehicle not found");
                return;
            }
            var singleHeavy=(JSONObject)heavyArray.get(0);
            System.out.println("heavy");
            System.out.println("plate number: " +singleHeavy.getInt("mispar_rechev"));
            System.out.println("manufacturer: " + singleHeavy.getString("tozeret_nm"));
            System.out.println("model: " + singleHeavy.getString("degem_nm"));
            System.out.println("engine: " + singleHeavy.getInt("nefach_manoa"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void readBikeJSON(String myJson) {
        try {
            var bikeData = new JSONObject(myJson);
            var result = bikeData.getJSONObject("result");
            var bikeArray = result.getJSONArray("records");
            if (bikeArray.length() == 0) {
                //System.out.println("bike not found");
                return;
            }
            System.out.println("motorcycle");
            var singleBike = (JSONObject) bikeArray.get(0);
            System.out.println("plate number: " + singleBike.getInt("mispar_rechev"));
            System.out.println("manufacturer: " + singleBike.getString("tezeret_nm"));
            System.out.println("model: " + singleBike.getString("degem_nm"));
            System.out.println("engine: " + singleBike.getInt("nefach_manoa"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void readCarJSON(String myJson) {
        //convert our string to json object
        try {
            //convert our String to json object (don't forget to import sax.json
            var carData = new JSONObject(myJson);
            //getting our result from json object;
            var result = carData.getJSONObject("result");
            //get json array from result
            var carArray = result.getJSONArray("records");
            if (carArray.length() == 0) {
                //System.out.println("Car not found");
                return ;
            }
            //get a single car from the array
            var singleCar = (JSONObject) carArray.get(0);

            System.out.println("plate number: " + singleCar.getInt("mispar_rechev"));
            System.out.println("manufacturer: " + singleCar.getString("tozeret_nm"));
            System.out.println("model: " + singleCar.getString("kinuy_mishari"));
            System.out.println("color: " + singleCar.getString("tzeva_rechev"));
            System.out.println("test: " + singleCar.getString("tokef_dt").split("T")[0]);
            //System.out.println("year: "+ singleCar.getInt("shnat_yitzur"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private String getURLdata(String url) {
        //string builder for getting data that will not be immutable
        StringBuilder stringBuilder = new StringBuilder();
        //create instance of connection to the internet
        HttpURLConnection httpURLConnection = null;

        try {
            //open a connection to the internet
            httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            //create buffer reader for getting data stream
            var buf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            //while not getting null, read next line
            while ((line = buf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //close the connection
            httpURLConnection.disconnect();
        }

        return stringBuilder.toString();
    }
}
