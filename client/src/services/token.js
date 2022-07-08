import * as storage from '../utils/storage';

import { ACCESS_TOKEN, REFRESH_TOKEN } from '../constants/storage';


export function persist({ accessToken, refreshToken }) {
  setAccessToken(accessToken);
  setRefreshToken(refreshToken);
}


export function getAccessToken() {
  return storage.get(ACCESS_TOKEN);
}


export function setAccessToken(accessToken) {
  storage.set(ACCESS_TOKEN, accessToken);
}


export function getRefreshToken() {
  return storage.get(REFRESH_TOKEN);
}


export function setRefreshToken(refreshToken) {
  return storage.set(REFRESH_TOKEN, refreshToken);
}

export function clear() {
  storage.clear();
}
