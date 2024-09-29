import { useContext, useEffect, useState } from "react";
import { Badge, Button, Col, Container, Form, Image, Nav, Navbar, NavDropdown, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import APIs, { endpoints } from "../../configs/API";
import { MyDispatchContext, MyUserContext } from "../../configs/Contexts";
import MySpinner from "./MySpinner";

const Header = () => {
    const [categories, setCategories] = useState(null);
    const [q, setQ] = useState("");
    const nav = useNavigate();
    const user = useContext(MyUserContext);
    const dispatch = useContext(MyDispatchContext);

    
    useEffect(() => {
        loadCates();
    }, []);


    const loadCates = async () => {
        try {
            const res = await API.get(endpoints['categories']);
            setCategories(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    const search = (e, cateId) => {
        e.preventDefault();
       
        // setCateId(cateId);
        nav(`/?cateId=${cateId}`)
    }

    const submit = (e) => {
        e.preventDefault();

        nav(`/?kw=${q}`);
    }
    

    return (
        <>
            {categories===null?<MySpinner />:<>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="#home">Journey - Van Tai - 2024</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        {/* <Nav.Link href="#home">Trang chủ</Nav.Link> */}
                        <Link className="nav-link" to="/" >Trang chủ</Link>
                        {/* <Nav.Link href="#link">Link</Nav.Link> */}
                        <NavDropdown title="Danh muc" id="basic-nav-dropdown">
                            {categories.map(c => <NavDropdown.Item key={c.id} href="#" onClick={e => search(e, c.id)}>{c.name}</NavDropdown.Item>)}
                        </NavDropdown>

                        {user===null?<>
                            <Link to="/register" className="nav-link text-success">Đăng ký</Link>
                            <Link to="/login" className="nav-link text-info">Đăng nhập</Link>
                        </>:<>
                            <Link to="/" className="nav-link text-success">
                                <Image src={user.avatar} width="40" roundedCircle /> {user.username}
                            </Link>
                            <Link onClick={() => dispatch({"type": "logout"})} className="nav-link">Đăng xuất</Link>
                        </>}
                       

                        <Link to="/jourDetails" className="nav-link">&#128722; <Badge bg="danger">0</Badge></Link>
                    </Nav>
                    </Navbar.Collapse>
                    <Form inline onSubmit={submit}>
                        <Row>
                            <Col xs="auto">
                                <Form.Control type="text" value={q} onChange={e => setQ(e.target.value)}  placeholder="Tìm sản phẩm..." className="mr-sm-2" />
                                
                            </Col>
                            <Col xs="auto">
                                <Button type="submit">Tìm kiếm</Button>
                            </Col>
                        </Row>
                    </Form>
                </Container>
               
            </Navbar></>}
        </>
    );
}


export default Header;