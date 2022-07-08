
const INITIAL_STATE = {
  isLoggedIn: false,
  user: {},
};

export default function (authState = INITIAL_STATE, action) {
  switch (action.type) {

    case 'SET_LOGGED_IN_USER':
      return {
        ...authState,
        user: action.data,
      };

    default:
      return authState;
  }
}
