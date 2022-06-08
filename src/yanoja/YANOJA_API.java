package yanoja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jex.data.JexData;

public class YANOJA_API {

	public static void main(String[] args) throws Exception {
		String jsonYnj = "{ \"code\": 200, \"data\": { \"no\": 23224, \"name\": [{ \"language\": \"ko\", \"name\": \"신촌 림\" }, { \"language\": \"en\", \"name\": \"Sinchon Reem\" }, { \"language\": \"zh-CN\", \"name\": \"新村 Reem酒店\" } ], \"address\": [{ \"language\": \"ko\", \"name\": \"서울특별시 서대문구 창천동 29-26\" }, { \"language\": \"en\", \"name\": \"29-26, Changcheon-dong, Seodaemun-gu, Seoul Sinchon Reem\" }, { \"language\": \"zh-CN\", \"name\": \"首尔西大门区沧川洞29-26 新村 Reem\" } ], \"addressRoad\": [{ \"language\": \"ko\", \"name\": \"서울 서대문구 연세로4길 16 (창천동)\" }, { \"language\": \"en\", \"name\": \"16, Yonsei-ro 4-gil, Seodaemun-gu, Seoul Sinchon Reem\" }, { \"language\": \"zh-CN\", \"name\": \"null 新村 Reem\" } ], \"isOpen\": 1, \"zipcode\": \"03779\", \"category\": \"Motel\", \"days\": 1, \"location\": \"신촌역 3번출구 도보 5분\", \"notices\": [{ \"no\": 221287, \"noticeType\": 4, \"order\": 0, \"title\": null, \"contents\": \"주차장이 협소한 관계로 차량이용자는 예약불가능합니다.\\r\\n객실요금은 2인 입실 기준이며, 파티룸 등 특수객실의 경우, 직접 입실 인원 확인이 필요합니다.\\r\\n미성년자의 입실 가능여부는 직접 제휴점에 확인 후 예약 진행하시기 바랍니다.\\r\\n미성년자 혼숙예약으로 인해 발생하는 입실 거부에 대해서는 취소/환불이 불가합니다.\\r\\n제휴점 사정에 의한 취소 발생 시 100% 환불 처리됩니다.\\r\\n제휴점 사정으로 객실 정보가 수시로 변경될 수 있습니다. 이로 인한 불이익은 당사가 책임지지 않습니다.\" } ], \"longitude\": 126.9379896, \"latitude\": 37.5569424, \"reserveEarly\": 1, \"cancelPolicies\": [{ \"seasonType\": 0, \"cancelPenaltyPercent\": 100, \"day\": 0, \"hour\": 24 }, { \"seasonType\": 0, \"cancelPenaltyPercent\": 0, \"day\": 1, \"hour\": 24 } ], \"cancelPolicyInfo\": \"- 입실 1일 전 24시 전까지 : 취소수수료 없음<br/>- 당일 취소 및 No-Show, 입실시간 경과/실제 입실 후 : 환불불가\", \"images\": [{ \"url\": \"https://yadev.yanolja.com/v5/2020/05/08/17/5eb5150064b8f5.07662184.jpg\", \"category\": \"REPRESENTATION\", \"categoryName\": \"대표 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/596011e7482149.13479267.JPG\", \"category\": \"FACILITY\", \"categoryName\": \"숙소 시설\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961025d398ff9.76208780.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961026071dd75.63158154.jpg\", \"category\": \"EXTERIOR\", \"categoryName\": \"숙소 외관\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/596102641f6a98.50673741.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/596011e6976e49.76703243.JPG\", \"category\": \"FACILITY\", \"categoryName\": \"숙소 시설\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/59610263ef1870.45511787.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/596102602ae487.19002046.jpg\", \"category\": \"EXTERIOR\", \"categoryName\": \"숙소 외관\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961025d1ce431.59216863.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/596011e6113d62.49801303.JPG\", \"category\": \"FACILITY\", \"categoryName\": \"숙소 시설\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961025cc29096.46707623.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/59610263614111.39651214.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961025c9e3de6.03381548.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961026345abb8.77726097.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/5961025c5e3476.27534528.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/596102630805a0.16846878.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/59610262b19fd0.59004442.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/01/59610262658bf1.52746635.jpg\", \"category\": \"AMENITY_AND_ETC\", \"categoryName\": \"기타\" } ], \"globalSalesAgree\": 0, \"amenities\": [{ \"no\": 28, \"order\": 11, \"amenityType\": 3, \"comment\": \"신촌/홍대/합정\" } ], \"roomTypes\": [{ \"no\": 2546, \"name\": [{ \"language\": \"ko\", \"name\": \"특 실\" }, { \"language\": \"en\", \"name\": \"Deluxe\" }, { \"language\": \"zh-CN\", \"name\": \"特室\" } ], \"capacity\": 2, \"maxCapacity\": 2, \"isOpen\": 1, \"description\": null, \"images\": [{ \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153b5ed3f6.87722664.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153b37f6a5.47845440.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153b1a1bf5.36068367.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153aeec0e9.76269553.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153ac27b60.25796138.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960193672b533.83464581.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960193652bc00.05512003.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601936351172.56021510.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596019361a0534.43213138.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960193600f975.68814627.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601935da8e62.67750006.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601935baa0d7.65524205.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153a996397.90597131.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153a75ce37.38618278.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153a58d889.55633247.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153a317048.52974661.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601539f35317.31834258.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601539d22312.64261145.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601539ae4e81.50245387.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122f3b95a5.67566758.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122f17ba57.88781858.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122eec6ed4.67787114.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122ec46985.55426978.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122e9fe9e1.72462641.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122e6d9c59.68524644.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122e536209.04526245.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/07/5960122e1d1365.00157767.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015397ae5e7.84179943.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153958f8b1.66829807.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015393c6dd3.85141246.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015391c1758.20138820.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601538ecd4a4.89905011.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601538cf5623.45506319.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601538af45e7.91765020.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601538925563.89497850.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153879a902.01822863.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601538611a34.77383902.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153844f884.63182709.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153827a216.66195866.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015380fc203.31570164.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601537e2aed2.84497571.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601537c1b283.90292115.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015378bf700.25644492.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015376fcf59.19495419.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153746f6a2.36408532.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601537314558.31612247.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601537139e14.30900115.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015367c6fb4.16693962.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601536e47ae5.56334832.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/59601536b4e6e7.28494484.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015369c8c57.89837726.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/596015365359e0.85866221.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153635b586.27772866.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" } ], \"globalSalesAgree\": 0, \"breakfast\": 0, \"confirmedReservation\": 1, \"rentAgree\": 0 }, { \"no\": 17232, \"name\": [{ \"language\": \"ko\", \"name\": \"디럭스\" }, { \"language\": \"en\", \"name\": \"Deluxe\" }, { \"language\": \"zh-CN\", \"name\": \"豪华房\" } ], \"capacity\": 2, \"maxCapacity\": 2, \"isOpen\": 1, \"description\": null, \"images\": [{ \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153e0d0e26.70757578.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153de7ab31.66760851.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153dc48635.48103725.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960150547b567.63055593.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153da43dd9.92028572.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/08/08/5960153d8c0744.56860919.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa01bd32d3.57696136.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa019564a1.05730831.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa016582a5.52863914.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa0147d498.31952685.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa01264bf2.42991597.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa02df6712.81793367.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa02ae3d89.68430385.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa02800ca2.37474299.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa02603832.03774728.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa02460084.51029860.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa021a6c99.82075512.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa01e995a4.75280470.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa0376b3d3.86575806.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa034ffd06.27627618.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa03307505.94474253.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" }, { \"url\": \"http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/07/12/595efa030adf56.88880036.jpg\", \"category\": \"ROOM_TYPE\", \"categoryName\": \"객실 사진\" } ], \"globalSalesAgree\": 0, \"breakfast\": 0, \"confirmedReservation\": 1, \"rentAgree\": 0 } ], \"keyword\": \"/서울모텔/신촌모텔/신촌모텔/신촌역/신촌/서울모텔/서대문구모텔/서대문모텔/창천동(신촌)모텔/창천동(신첩晁?서울숙박/서대문구숙박/서대문숙박/창천동(신촌)숙박/창천동(신체蕩?서울호텔/서대문구호텔/서대문호텔/창천동(신촌)호텔/창천동(신쳰Ｅ?커플PC/서울모텔/서대문구모텔/서대문모텔/창천동(신촌)모텔/창천동(신첩晁?서울숙박/서대문구숙박/서대문숙박/창천동(신촌)숙박/창천동(신체蕩?서울호텔/서대문구호텔/서대문호텔/창천동(신촌)호텔/창천동(신쳰Ｅ?/서울모텔/서대문구모텔/서대문모텔/창천동(신촌)모텔/창천동(신첩晁?서울숙박/서대문구숙박/서대문숙박/창천동(신촌)숙박/창천동(신체蕩?서울호텔/서대문구호텔/서대문호텔/창천동(신촌)호텔/창천동(신쳰Ｅ?/서울모텔/서대문구모텔/서대문모텔/창천동(신촌)모텔/창천동(신첩晁?서울숙박/서대문구숙박/서대문숙박/창천동(신촌)숙박/창천동(신체蕩?서울호텔/서대문구호텔/서대문호텔/창천동(신촌)호텔/창천동(신쳰Ｅ?/서울모텔/서대문구모텔/서대문모텔/창천동모텔/창천모텔/서울숙박/서대문구숙박/서대문숙박/창천동숙박/창천숙박/서울호텔/서대문구호텔/서대문호텔/창천동호텔/창천호텔/신촌모텔/신촌역/신촌/서울모텔/신촌모텔/신촌모텔/신촌역/신촌/신촌 림/신촌림/림/reem/fla/flaghxpf/tlschs/신촌 림/\", \"checkInTime\": \"23:00\", \"checkOutTime\": \"12:00\" } } ";
		YANOJA_API obj = new YANOJA_API();
		JSONObject propObj 		= new JSONObject(jsonYnj);
		JSONObject propObjItem 	= new JSONObject(propObj.get("data").toString());
		String[] YNJ_LANGUAGES  = {"ko","en","zh-CN"};
		String	YNJ_LANG_CDOE   = "";
		String test		= "{ \"startDate\": \"2020-08-12\", \"endDate\": \"\", \"places\": [ { \"placeNo\": \"12121212\"},{ \"placeNo\": \"\" } ] }";
		String errMsg	= "";
		String errCode	= "";
		boolean nullCheck = true;
		int chkPlaceNo	= 0;
		JSONObject paramObj	= new JSONObject(test.toString());
		
		System.out.println("strStartDate:: "+paramObj.get("startDate"));
		System.out.println("strEndDate:: "+paramObj.get("endDate"));
		
		if(paramObj.isNull("startDate") || paramObj.get("startDate").equals("")) {
			errMsg	= "startDate param is required.";
			errCode = "9990";
			nullCheck = false;
		}
		
		if(paramObj.isNull("endDate") || paramObj.get("endDate").equals("")) {
			errMsg 	= "endDate param is required.";
			errCode = "9991";
			nullCheck = false;
		}
		
		if(!paramObj.isNull("places")) {
			JSONArray paramPlaces	= new JSONArray(paramObj.get("places").toString());
			if(paramPlaces.length() > 0) {
				for(int i = 0; i < paramPlaces.length(); i++) {
					JSONObject placeNo		= new JSONObject(paramPlaces.get(i).toString());
					if(!placeNo.get("placeNo").equals("")) {
						chkPlaceNo++;
					}
				}
			}else {
				errMsg = "places param is required.";
				nullCheck = false;
			}
		}else {
			errMsg = "places param is required.";
			nullCheck = false;
		}
		
		if(chkPlaceNo == 0) {
			errMsg = "placeNo param is required.";
			nullCheck = false;
		}
		
		if(!nullCheck) {
			System.out.println("paramPlaces msg:: "+errMsg);
		}
//		obj.processHotelListData(propObjItem, "");
		
		/*String column = "";
		column += "INSERT INTO BT_HOTEL_LIST (";
		column += "HOTEL_SEQ,";
		column += "LANGUAGE_CODE,";
		column += "AFFILIATE_ID,";
		column += "EPS_HOTEL_ID,";
		column += "HOTEL_NAME,";
		column += "COUNTRY_CODE,";
		column += "CITY_NAME,";
		column += "LATITUDE,";
		column += "LONGITUDE,";
		column += "ADDRESS_LINE_1,";
		column += "ADDRESS_LINE_2,";
		column += "STATE_PROVINCE_CODE,";
		column += "STATE_PROVINCE_NAME,";
		column += "POSTAL_CODE,";
		column += "OBFUSCATED,";
		column += "LOCALIZED,";
		column += "RATINGS,";
		column += "PHONE,";
		column += "FAX,";
		column += "CATEGORY_ID,";
		column += "CATEGORY_NAME,";
		column += "EXPEDIA_COLLECT,";
		column += "PROPERTY_COLLECT,";
		column += "RANK,";
		column += "CHECKIN,";
		column += "CHECKOUT_TIME,";
		column += "FEES,";
		column += "KNOW_BEFORE_YOU_GO,";
		column += "ATTRIBUTES,";
		column += "AMENITIES_ID,";
		column += "AMENITIES_NAME,";
		column += "IMAGES,";
		column += "ONSITE_PAYMENTS,";
		column += "ROOMS,";
		column += "RATES,";
		column += "DATES_ADDED,";
		column += "DATES_UPDATED,";
		column += "DESCRIPTIONS,";
		column += "STATISTICS,";
		column += "IATA_AIRPORT_CODE,";
		column += "REGISTRY_NUMBER,";
		column += "THEMES,";
		column += "ALL_INCLUSIVE_DETAILS,";
		column += "TAX_ID,";
		column += "CHAIN,";
		column += "BRAND,";
		column += "SPOKEN_LANGUAGES,";
		column += "MULTI_UNIT,";
		column += "CREATE_DT,";
		column += "CREATE_USER,";
		column += "MOD_DT,";
		column += "MOD_USER,";
		column += "IS_OPEN,";
		column += "DAYS,";
		column += "LOCATION,";
		column += "RESERVE_EARLY,";
		column += "RESERVATION_TYPE,";
		column += "KEYWORD,";
		column += "MIN_PRICE,";
		column += "EXT_8,";
		column += "EXT_9,";
		column += "EXT_10)";
		column += "VALUES";
		
		System.out.println(column);
		JSONArray propNameArr = new JSONArray(propObjItem.get("name").toString());
		String sqlDelete = "";
		for(int i = 0; i < 3;i++) {
			if(YNJ_LANGUAGES[i].equals("ko")) {
				YNJ_LANG_CDOE = "ko-KR";
			}else if(YNJ_LANGUAGES[i].equals("en")) {
				YNJ_LANG_CDOE = "en-US";
			}else if(YNJ_LANGUAGES[i].equals("zh-CN")) {
				YNJ_LANG_CDOE = "zh-CN";
			}
			
			JSONObject propNameObj = new JSONObject(propNameArr.get(i).toString());
			if(propNameObj.getString("language").equals(YNJ_LANG_CDOE)){
				sqlDelete += "DELETE FROM BT_HOTEL_NAME WHERE HOTEL_NAME = '"+propNameObj.getString("name")+"' AND HOTEL_SEQ = '"+propObjItem.get("no").toString()+"'; \n";			// 삭제쿼리 생성 BT_HOTEL_NAME
				System.out.println("propNameObj:: "+sqlDelete);
			}
		}*/
		
	}
	
	private String processHotelListData(JSONObject propEle, String language,String languageCode) throws Exception{
		JSONArray propNameArr = new JSONArray(propEle.get("name").toString());
		String propHotelNo	  = propEle.get("no").toString();
		String hotelName  = "";
		String line		  = "";
		String SP		  = "'";
		
		for(int i = 0;i < propNameArr.length();i++){
			JSONObject propNameObj = new JSONObject(propNameArr.get(i).toString());
			if(propNameObj.getString("language").equals(language)){
				hotelName = propNameObj.getString("name");
			}
		}
		
		// hotel address data
		JSONArray propAddressArr    = new JSONArray(propEle.get("address").toString());
		JSONArray propAddRaodArr    = new JSONArray(propEle.get("addressRoad").toString());
		String ynjHotelPostalCode 	= (!propEle.isNull("zipcode")   ? propEle.get("zipcode").toString() : "null");
		String ynjHotelLine1 		= "";
		String ynjHotelLine2 		= "";
		String ynjIsOpen	 		= (!propEle.isNull("isOpen")   ? propEle.get("isOpen").toString() : "null");
		String ynjCategory	 		= (!propEle.isNull("category")   ? propEle.get("category").toString() : "null");
		String ynjThemes	 		= (!propEle.isNull("themes")   ? propEle.get("themes").toString() : "null");
		String ynjStar		 		= (!propEle.isNull("star")   ? setHotelStar(propEle.get("star").toString()) : "null");
		String ynjDays		 		= (!propEle.isNull("days")   ? propEle.get("days").toString() : "null");
		String ynjLocation		 	= (!propEle.isNull("location")   ? propEle.get("location").toString() : "null");
		String ynjNotices		 	= (!propEle.isNull("notices")   ? propEle.get("notices").toString() : "null");
		Double hotelLatitude		= Double.parseDouble(propEle.get("latitude").toString());
		Double hotelLongitude		= Double.parseDouble(propEle.get("longitude").toString());
		String ynjReserveEarly	 	= (!propEle.isNull("reserveEarly")   ? propEle.get("reserveEarly").toString() : "null");
		String ynjCancelPolicies	= (!propEle.isNull("cancelPolicies")   ? propEle.get("cancelPolicies").toString() : "null");
		String ynjCancelPolicyInfo	= (!propEle.isNull("cancelPolicyInfo")   ? propEle.get("cancelPolicyInfo").toString() : "null");
		String ynjHotelImages		= (!propEle.isNull("images")   ? propEle.get("images").toString() : "null");
		String ynjGlobalSalesAgree	= (!propEle.isNull("globalSalesAgree")   ? propEle.get("globalSalesAgree").toString() : "null");
		String ynjAmenities			= (!propEle.isNull("amenities")   ? propEle.get("amenities").toString() : "null");
		String ynjRoomTypes			= (!propEle.isNull("roomTypes")   ? propEle.get("roomTypes").toString() : "null");
		String ynjKeyword			= (!propEle.isNull("keyword")   ? propEle.get("keyword").toString() : "null");
		String ynjIntroduction		= (!propEle.isNull("introduction")   ? propEle.get("introduction").toString() : "null");
		String ynjCheckInTime		= (!propEle.isNull("checkInTime")   ? setCheckInTime(propEle.get("checkInTime").toString()) : "null");
		String ynjCheckOutTime		= (!propEle.isNull("checkOutTime")   ? propEle.get("checkOutTime").toString() : "null");
		
		
		for(int i = 0;i < propAddressArr.length();i++){
			JSONObject propAddObj = new JSONObject(propAddressArr.get(i).toString());
			if(propAddObj.getString("language").equals(language)){
				ynjHotelLine1 = propAddObj.getString("name");
			}
		}
		
		for(int i = 0;i < propAddRaodArr.length();i++){
			JSONObject propAddObj = new JSONObject(propAddRaodArr.get(i).toString());
			if(propAddObj.getString("language").equals(language)){
				ynjHotelLine2 = propAddObj.getString("name");
			}
		}
		
		/*System.out.println("propHotelNo:: "+propHotelNo);
		System.out.println("hotelName:: "+hotelName);
		System.out.println("ynjHotelLine1:: "+ynjHotelLine1);
		System.out.println("ynjHotelLine2:: "+ynjHotelLine2);
		System.out.println("ynjHotelPostalCode:: "+ynjHotelPostalCode);
		System.out.println("ynjIsOpen:: "+ynjIsOpen);
		System.out.println("ynjCategory:: "+ynjCategory);
		System.out.println("ynjThemes:: "+ynjThemes);
		System.out.println("ynjStar:: "+ynjStar);
		System.out.println("ynjDays:: "+ynjDays);
		System.out.println("ynjLocation:: "+ynjLocation);
		System.out.println("ynjNotices:: "+ynjNotices);
		System.out.println("hotelLatitude:: "+hotelLatitude);
		System.out.println("hotelLongitude:: "+hotelLongitude);
		System.out.println("ynjReserveEarly:: "+ynjReserveEarly);
		System.out.println("ynjCancelPolicies:: "+ynjCancelPolicies);
		System.out.println("ynjCancelPolicyInfo:: "+ynjCancelPolicyInfo);
		System.out.println("ynjHotelImages:: "+ynjHotelImages);
		System.out.println("ynjGlobalSalesAgree:: "+ynjGlobalSalesAgree);
		System.out.println("ynjAmenities:: "+ynjAmenities);
		System.out.println("ynjRoomTypes:: "+ynjRoomTypes);
		System.out.println("ynjKeyword:: "+ynjKeyword);
		System.out.println("ynjIntroduction:: "+ynjIntroduction);
		System.out.println("ynjCheckInTime:: "+ynjCheckInTime);
		System.out.println("ynjCheckOutTime:: "+ynjCheckOutTime);*/
		
		/*line += "("					;
		line += 	  SP +  propHotelNo			  + SP; // ynjHotelSeq
		line += "," + SP +  languageCode		  + SP; // ynjLanguageCode
		line += "," + SP +  "002"				  + SP; // affiliate_id
		line += "," + SP +  propHotelNo			  + SP; // eps_hotel_id
		line += "," + SP +  hotelName			  + SP; // ynjHotelName
		line += "," + SP +  "KR"				  + SP; // ynjHotelCountryCode
		line += "," + SP +  ""				 	  + SP; // ynjHotelCity
		line += "," +		hotelLatitude		  	  ;
		line += "," +		hotelLongitude		  	  ;
		line += "," + SP +  ynjHotelLine1 	  	  + SP; // epsHotelLine1
		line += "," + SP +  ynjHotelLine2 	  	  + SP; // epsHotelLine2
		line += "," + SP +  ""					  + SP; // ynjHotelStateCode
		line += "," + SP +  ""					  + SP; // ynjHotelStateName
		line += "," + SP +  ynjHotelPostalCode 	  + SP; // epsHotelPostalCode
		line += "," +		false				      ; // epsHotelObfuscated
		line += "," + SP +  null				  + SP; // epsHotelLocalized
		line += "," + 		ynjStar				  	  ; // propObjRatings
		line += "," + SP +  ""			 	 	  + SP; // hotelPhone
		line += "," + SP +  ""			 	 	  + SP; // hotelFax
		line += "," + SP +  ""				 	  + SP; // epsHotelCatId
		line += "," + SP +  ynjCategory		 	  + SP; // epsHotelCatNm
		line += "," + 	    false				  	  ; // epsHotelExpColl
		line += "," + 		false				      ; // epsHotelPropColl
		line += "," +  		0					  	  ; // hotelRank
		line += "," +		ynjCheckInTime 		      ; // propObjCheckin
		line += "," + SP +  ynjCheckOutTime 	  + SP; // propObjCheckout
		line += "," + 		null			 	 	  ; // propObjFee
		line += "," + SP +  ynjCancelPolicyInfo   + SP; // propObjKnow
		line += "," + 		null			 	 	  ; // propObjAttr
		line += "," + SP +  ""			 	 	  + SP; // newAmtyId
		line += "," + SP +  ynjAmenities	 	  + SP; // newAmtyNm
		line += "," + SP +  ynjHotelImages 		  + SP; // imageJSON
		line += "," + 		null			 	 	  ; // propObjOnsitePayment
		line += "," + SP +  ynjRoomTypes 		  + SP; // propObjRoomsJson
		line += "," + 		null			 	 	  ; // propObjRates
		line += "," + SP +  ""				 	  + SP; // epsHotelAdded
		line += "," + SP +  ""				 	  + SP; // epsHotelUpdated
		line += "," + SP +  ynjIntroduction 	  + SP; // propObjDesc
		line += "," + 		null			 	 	  ; // propObjStatics
		line += "," + SP +  ""					  + SP; // epsHotelAirportCode
		line += "," + SP +  ""					  + SP; // hotelRegistryNumber
		line += "," + SP +  ynjThemes 		 	  + SP; // propObjThemse
		line += "," + 		null			 	 	  ; // propObjAllInclusive
		line += "," + SP +  ""			 	 	  + SP; // hotelTaxId
		line += "," + 		null			 	 	  ; // propObjChain
		line += "," + 		null			 	 	  ; // propObjBrand
		line += "," + 		null			 	 	  ; // propObjSpokenLang
		line += "," +		false				      ; // hotelMultiUnit
		line += "," + SP +  "2020-08-02 00:00:00" + SP;
		line += "," + SP +  "admin"		 	 	  + SP;
		line += "," + SP +  ""					  + SP; // hotelModifyDate
		line += "," + SP +  ""					  + SP; // hotelModifyUser
		line += "," + SP +  ynjIsOpen			  + SP; // ynjIsOpen
		line += "," + SP +  ynjDays				  + SP; // ynjDays
		line += "," + SP +  ynjLocation			  + SP; // ynjLocation
		line += "," + SP +  ynjReserveEarly		  + SP; // ynjReserveEarly
		line += "," + SP +  ""					  + SP; // 여기어때 reservationType
		line += "," + SP +  ""					  + SP; // ynjKeyword --> ynjKeyword
		line += "," + SP +  ""					  + SP; // 여기어때 minPrice
		line += "," + SP +  ""					  + SP; // EXT_8
		line += "," + SP +  ""					  + SP; // EXT_9
		line += "," + SP +  ""					  + SP; // EXT_10
		line += ")";*/
		
		JSONArray amttArr = new JSONArray(ynjAmenities.toString());
		for(int i = 0; i < amttArr.length();i++){
			JSONObject amttItem = new JSONObject(amttArr.get(i).toString());
			line += "("									  ;
			line += 	  SP +  propHotelNo			  + SP; // ynjHotelSeq
			line += "," + SP +  propHotelNo			  + SP; // ynjHotelNo
			line += "," + SP +  amttItem.get("no") + SP; // ynjAmenityId
			line += "," +		"002"				  	  ;	// ext_1
			line += "," +		""					  	  ;	// ext_2
			line += "," + SP +  ""				 	  + SP; // ext_3
			line += ")";
		}
		
		
		return line;
	}
	
	String setHotelStar(String cntStar) {
		return "'{\"property\":{\"rating\":\""+cntStar+"\",\"type\":\"Star\"}}"+"'::JSON";
	}
	
	String setCheckInTime(String chkInTime) {
		return "'{\"begin_time\":\""+chkInTime+"\"}"+"'::JSON";
	}
}
