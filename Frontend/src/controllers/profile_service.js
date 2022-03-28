/**
 * @fileoverview Profile Data Service Methods
 */
import http from "../connections/http_common";

/**
 * Class with methods to retrieve profile data
 */
class ProfileDataService {
  /**
   * Retrieve all Profiles
   * @returns {Array} all profiles
   */
  getAll() {
    return http.get("/profiles");
  }
  /**
   * Retrieves a single Profile given the profile id as a parameter
   * @param {Number} id profile id to retrieve
   * @returns {Object} the profile retrieved
   */
  get(id) {
    return http.get(`/profile/${id}`);
  }
}
export default new ProfileDataService();
