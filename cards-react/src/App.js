import './index.css';
import 'antd/dist/antd.css';
import globalReducer from './core/reducers/index';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import Header from './components/layout/Header';
import Router from "./Router";

export const App = (props) => {
  const appStore = createStore(globalReducer);

  return (
    <Provider store={appStore}>
      <div className="App">
        <Header></Header>
        <Router></Router>
      </div>
    </Provider>
  );
}

export default App;
