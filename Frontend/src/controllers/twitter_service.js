/**
 * @fileoverview Twitter Data Service Methods to retrieve data from the
 *   Twitter API
 */
import http from "../connections/http_twitter";

/**
 * Class with methods to retrieve twitter data
 */
class TwitterDataService {
  /**
   * Retrieve the last 5 Tweets of the used: id
   * @param {Number} id user id in twitter
   * @returns {Array} returns an array of tweets
   */
  get5Tweets(id) {
    return http.get(`twitter/${id}`);
  }
}
export default new TwitterDataService();
