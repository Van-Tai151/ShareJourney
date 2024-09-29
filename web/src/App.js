import { BrowserRouter,Route,Routes } from 'react-router-dom';
import Footer from './components/Commons/Footer';
import Home from './components/Journey/Home';
import Header from './components/Commons/Header';
import 'bootstrap/dist/css/bootstrap.min.css'
const App = () => {
  return (
    <BrowserRouter>
    <Header />
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    <Footer/>
    </BrowserRouter>
  );
}
export default App;