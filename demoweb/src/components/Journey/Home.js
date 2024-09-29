
import { useEffect, useState } from "react";
import { Button, Card, Col, Container, Row } from "react-bootstrap";
import cookie from "react-cookies";
import { useNavigate, useSearchParams } from "react-router-dom";
import API, { endpoints } from "../../configs/API";
import MySpinner from "../Commons/MySpinner";


const Home = () => {
    
    const [journeys, setJourneys] = useState([]);
    const [loading, setLoading] = useState(false);
    
    const [page, setPage] = useState(1);
    const nav = useNavigate();
    const [q, ] = useSearchParams();

    const loadJourneys = async () => {
        setLoading(true)
        try {
            let url = `${endpoints['journeys']}?page=${page}`;

            let cateId = q.get('cateId')
            if (cateId) {
                setPage(1);
                url = `${url}&cateId=${cateId}`;
            }

            let kw = q.get("kw");
            if (kw) {
                setPage(1);
                url = `${url}&kw=${kw}`;
            }

            console.info(url)
            const res = await API.get(url);

            if (page === 1)
                setJourneys(res.data);
            else 
                setJourneys(current => {
                    return [...current, ...res.data];
                })
        } catch (ex) {
            console.error(ex);
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        loadJourneys();
    }, [q, page]);

    

    const loadMore = () => {
        if (!loading)
            setPage(page + 1);
    }

    return (
        <>            
            <Container>
                {loading && <MySpinner />}
                <Row>
                   {journeys.map(j => <>
                        <Col md={4} xs={12} className='p-2'>
                            <Card>                               
                                <Card.Body>
                                    <Card.Title>{j.fromLocation}</Card.Title>
                                    <Card.Title>{j.toLocation}</Card.Title>
                                    <Card.Title>{j.estimatedTime}</Card.Title>
                                    <Button variant="primary" className="m-1" onClick={() => nav(`/journeys/${j.id}`)}>Xem chi tiết</Button>
                                </Card.Body>
                            </Card>
                        </Col>
                   </>)}
                </Row>
                {loading && page > 1 && <MySpinner />}
                <div className="text-center">
                    <Button variant="info" onClick={loadMore} disabled={loading}>Xem thêm</Button>
                </div>
            </Container>
            

        </>
    );
}

export default Home;