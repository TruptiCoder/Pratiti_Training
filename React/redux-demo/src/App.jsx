import React from 'react';
import { Provider, useDispatch, useSelector } from 'react-redux';
import store from './store';
import { increment, decrement } from './actions';
import MyComp from './MyComp';

const CounterComponent = () => {
  const count = useSelector((state) => state.count);
  const dispatch = useDispatch();

  return (
    <div className='m-5 p-5 text-bg-dark rounded'>
      <h1>Count: {count}</h1>
      <button className='btn btn-danger' title="Increment" onClick={() => dispatch(increment())}>Increment</button>
      <button className='btn btn-danger mx-5' title="Decrement" onClick={() => dispatch(decrement())}>Decrement</button>
    </div>
  );
};

const App = () => {
  return (
    <Provider store={store}>
      <CounterComponent />
      <MyComp />
    </Provider>
  );
};

export default App;