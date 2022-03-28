import React, { useState, useEffect } from "react";
import ProfileDataService from "./controllers/profile_service";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import Tweets from "./components/Tweets";

function App() {
  const [profile, setProfile] = useState([]);

  useEffect(() => {
    retrieveProfile();
    return () => {};
  }, []);

  const retrieveProfile = () => {
    ProfileDataService.get(117)
      .then((response) => {
        setProfile(response.data[0]);
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  };

  return (
    <>
      <div className="container mt-3 col-sm-6 border rounded ">
        <div className="row mx-2">
          <div className="col my-3">
            <img
              src={profile.imageUrl}
              alt="Twitter profile user"
              className="img-thumbnail rounded mb-3 "
            />
            <div className="border rounded-3">
              <div className="border-bottom my-2 mx-2">
                <h4>{profile.names}'s Timeline</h4>
              </div>
              <Tweets twitterUserId={profile.twitterUserId}></Tweets>
              <div className="my-2 mx-2">
                <a
                  href={`https://twitter.com/${profile.twitterUserName}`}
                  target="_blank"
                  rel="noreferrer"
                  className="text-decoration-none"
                >
                  Go to Account {">"}
                </a>
              </div>
            </div>
          </div>
          <div className="col border rounded-3  my-3">
            <h1>
              {profile.tittle} {profile.names} {profile.lastNames}
            </h1>
            <div className="border-bottom my-2">
              <h4>My Work Experience</h4>
            </div>
            <div className="mt-3">{profile.experience_summary}</div>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
