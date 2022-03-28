import React from "react";
import { Routes, Route } from "react-router-dom";
import Profile from "../views/Profile";

function AppRoutes() {
  return (
    <Routes>
      <Route exact path="/" element={<Profile />} />
      <Route path="/:id" element={<Profile />} />
    </Routes>
  );
}

export default AppRoutes;
