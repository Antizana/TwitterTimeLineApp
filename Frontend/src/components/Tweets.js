import React, { useState, useEffect } from "react";
import TwitterDataService from "../controllers/twitter_service";

function Tweets(props) {
  const [tweets, setTweets] = useState([]);

  useEffect(() => {
    retrieveTweets(props.twitterUserId);
    return () => {};
  }, [props.twitterUserId]);

  const retrieveTweets = (twitterUserId) => {
    if (!twitterUserId) return;
    TwitterDataService.get5Tweets(twitterUserId)
      .then((response) => {
        setTweets(response.data);
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  };

  return (
    <>
      <table className="table">
        <tbody>
          {tweets &&
            tweets.map((tweet) => (
              <tr key={tweet.id}>
                <td>
                  <img src={tweet.photo} alt="Twitter User" />
                </td>
                <td>
                  <div>
                    <strong>{tweet.userName}</strong>
                  </div>
                  {tweet.text}
                </td>
              </tr>
            ))}
        </tbody>
      </table>
    </>
  );
}

export default Tweets;
