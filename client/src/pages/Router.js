import React from 'react'
import {Routes, Route} from 'react-router-dom'
import UserProfile from '../components/profiles/UserProfile'
export default function Router(){
    return(
        <div>
            <Routes>
                {/* <Route path="/main" element={<Main />}>Main</Route> */}
                <Route path="/user-profile" element={<UserProfile />}></Route>
            </Routes>
        </div>
    )
}