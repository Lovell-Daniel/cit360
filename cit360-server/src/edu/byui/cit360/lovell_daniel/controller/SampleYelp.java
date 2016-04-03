package edu.byui.cit360.lovell_daniel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SampleYelp {
	
	private static String staticYelpJSON = "{'region': {'span': {'latitude_delta': 0.02443334653892748, 'longitude_delta': 0.012525259999989657}, 'center': {'latitude': 43.828934033391405, 'longitude': -111.7829285}}, 'total': 26, 'businesses': [{'is_claimed': true, 'rating': 4.0, 'mobile_url': 'http://m.yelp.com/biz/the-burg-rexburg?utm_campaign=yelp_api\u0026utm_medium=api_v2_search\u0026utm_source=q9Ln-6QxbT8dZ4L2yUh6Gw', 'rating_img_url': 'https://s3-media4.fl.yelpcdn.com/assets/2/www/img/c2f3dd9799a5/ico/stars/v1/stars_4.png', 'review_count': 25, 'name': 'The Burg', 'rating_img_url_small': 'https://s3-media4.fl.yelpcdn.com/assets/2/www/img/f62a5be2f902/ico/stars/v1/stars_small_4.png', 'url': 'http://www.yelp.com/biz/the-burg-rexburg?utm_campaign=yelp_api\u0026utm_medium=api_v2_search\u0026utm_source=q9Ln-6QxbT8dZ4L2yUh6Gw', 'categories': [['Burgers', 'burgers'], ['Fast Food', 'hotdogs']], 'phone': '2084166500', 'snippet_text': 'I'm here way more often than either my waistline or my wallet would like. (If you're ever here and see a girl with a ponytail, bangs, and glasses tapping...', 'image_url': 'https://s3-media1.fl.yelpcdn.com/bphoto/1_UhQG_G2j7J2nwEn5QMdw/ms.jpg', 'snippet_image_url': 'http://s3-media3.fl.yelpcdn.com/photo/7a0q7Fx-ydS85eewf-q6vQ/ms.jpg', 'display_phone': '+1-208-416-6500', 'rating_img_url_large': 'https://s3-media2.fl.yelpcdn.com/assets/2/www/img/ccf2b76faa2c/ico/stars/v1/stars_large_4.png', 'id': 'the-burg-rexburg', 'is_closed': false, 'location': {'city': 'Rexburg', 'display_address': ['110 W. 4th S', 'Rexburg, ID 83440'], 'geo_accuracy': 9.5, 'postal_code': '83440', 'country_code': 'US', 'address': ['110 W. 4th S'], 'coordinate': {'latitude': 43.8178279667828, 'longitude': -111.786943426188}, 'state_code': 'ID'}}, {'is_claimed': false, 'rating': 4.0, 'mobile_url': 'http://m.yelp.com/biz/mandarin-restaurant-rexburg?utm_campaign=yelp_api\u0026utm_medium=api_v2_search\u0026utm_source=q9Ln-6QxbT8dZ4L2yUh6Gw', 'rating_img_url': 'https://s3-media4.fl.yelpcdn.com/assets/2/www/img/c2f3dd9799a5/ico/stars/v1/stars_4.png', 'review_count': 34, 'name': 'Mandarin Restaurant', 'rating_img_url_small': 'https://s3-media4.fl.yelpcdn.com/assets/2/www/img/f62a5be2f902/ico/stars/v1/stars_small_4.png', 'url': 'http://www.yelp.com/biz/mandarin-restaurant-rexburg?utm_campaign=yelp_api\u0026utm_medium=api_v2_search\u0026utm_source=q9Ln-6QxbT8dZ4L2yUh6Gw', 'categories': [['Chinese', 'chinese']], 'phone': '2083565688', 'snippet_text': 'Been looking in vain for decent asian food here in southeastern idaho since moving here from southern california. The wife and I were pleasantly surprised...', 'image_url': 'https://s3-media3.fl.yelpcdn.com/bphoto/vu5u4OWTKgrXZX7q3u0EIw/ms.jpg', 'snippet_image_url': 'https://s3-media4.fl.yelpcdn.com/assets/srv0/yelp_styleguide/cc4afe21892e/assets/img/default_avatars/user_medium_square.png', 'display_phone': '+1-208-356-5688', 'rating_img_url_large': 'https://s3-media2.fl.yelpcdn.com/assets/2/www/img/ccf2b76faa2c/ico/stars/v1/stars_large_4.png', 'id': 'mandarin-restaurant-rexburg', 'is_closed': false, 'location': {'city': 'Rexburg', 'display_address': ['222 E 7th N', 'Rexburg, ID 83440'], 'geo_accuracy': 8.0, 'postal_code': '83440', 'country_code': 'US', 'address': ['222 E 7th N'], 'coordinate': {'latitude': 43.8400497, 'longitude': -111.7774277}, 'state_code': 'ID'}}, {'is_claimed': true, 'rating': 3.5, 'mobile_url': 'http://m.yelp.com/biz/the-hickory-rexburg?utm_campaign=yelp_api\u0026utm_medium=api_v2_search\u0026utm_source=q9Ln-6QxbT8dZ4L2yUh6Gw', 'rating_img_url': 'https://s3-media1.fl.yelpcdn.com/assets/2/www/img/5ef3eb3cb162/ico/stars/v1/stars_3_half.png', 'review_count': 62, 'name': 'The Hickory', 'rating_img_url_small': 'https://s3-media1.fl.yelpcdn.com/assets/2/www/img/2e909d5d3536/ico/stars/v1/stars_small_3_half.png', 'url': 'http://www.yelp.com/biz/the-hickory-rexburg?utm_campaign=yelp_api\u0026utm_medium=api_v2_search\u0026utm_source=q9Ln-6QxbT8dZ4L2yUh6Gw', 'categories': [['Barbeque', 'bbq']], 'menu_date_updated': 1459518098, 'phone': '2083592328', 'snippet_text': 'The hickory is my favorite place in Rexburg to eat. You must go every time you come to Rexburg. The food is in large quantities, fresh and delicious!!', 'image_url': 'https://s3-media2.fl.yelpcdn.com/bphoto/oUQbaNU5jkAniMyTvnBgfw/ms.jpg', 'snippet_image_url': 'http://s3-media4.fl.yelpcdn.com/photo/dnq_ljnIx1u1784tW1QvZA/ms.jpg', 'display_phone': '+1-208-359-2328', 'rating_img_url_large': 'https://s3-media3.fl.yelpcdn.com/assets/2/www/img/bd9b7a815d1b/ico/stars/v1/stars_large_3_half.png', 'menu_provider': 'single_platform', 'id': 'the-hickory-rexburg', 'is_closed': false, 'location': {'city': 'Rexburg', 'display_address': ['155 W Main St', 'Rexburg, ID 83440'], 'geo_accuracy': 8.0, 'postal_code': '83440', 'country_code': 'US', 'address': ['155 W Main St'], 'coordinate': {'latitude': 43.82539, 'longitude': -111.78844}, 'state_code': 'ID'}}]}";
	
	public static String getSampleYelp() {
	
		try {
			URL url = new URL("http://pearedup.lovelllabs.com/yelp.php");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			return json;
		} catch (IOException e) {
			System.out.println("Couldn't connect. Using backup yelp string.");
			return staticYelpJSON;
		}
	}
}
