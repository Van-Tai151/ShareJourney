import { useEffect, useState } from "react";
import API, { endpoints } from "../../configs/API";
import { Container, NavDropdown, Navbar, Spinner } from "react-bootstrap";

const Header = () => {
    const [categories, setCategories] = useState(null);
    const loadCates = async () => {
        try {
            let res = await API.get(endpoints['categories']);
            setCategories(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }
    useEffect(() => { //de rong dung 1 lan.
        loadCates();
    }, []);

    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">Journey - Van Tai - 2024</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Trang chủ</Nav.Link>
                        {/* <Link className="nav-link" to="/" >Trang chủ</Link> */}
                        {/* <Nav.Link href="#link">Link</Nav.Link> */}
                        <NavDropdown title="Danh muc" id="basic-nav-dropdown">
                            {categories===null?<Spinner animation="grow" variant="primary"/>:<>
                            {categories.map(c => <NavDropdown.Item key={c.id} href="#action/3.1">{c.name}</NavDropdown.Item>)}
                            </>}
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}
export default Header;