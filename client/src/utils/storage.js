

export function get(key) {
  const value = localStorage.getItem(key);

  if (!value) {
    return null;
  }

  return JSON.parse(value);
}


export function set(key, value) {
  localStorage.setItem(key, JSON.stringify(value));
}


export function remove(key) {
  localStorage.removeItem(key);
}


export function clear() {
  return localStorage.clear();
}
