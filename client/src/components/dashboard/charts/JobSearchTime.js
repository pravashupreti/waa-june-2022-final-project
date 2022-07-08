import ReactECharts from 'echarts-for-react';  

function JobSearchTime(props) {
    const option = {
        title: {
            text: 'Number Of Days Required To Search Job',
            subtext: 'Per GPA',
            left: 'center'
        },
        xAxis: {
            type: 'category',
            data: ['2.0 - 2.2', '2.3 - 2.6', '2.7 - 2.9', '3.0 - 3.2', '3.3 - 3.6', '3.7 - 4.0']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: [120, 200, 150, 80, 70, 110],
                type: 'bar'
            }
        ]
    };

    return (
        <div className='card'>

            <ReactECharts
                option={option}
                notMerge={true}
                lazyUpdate={true}
                theme={"theme_name"}
                style={{height: '500px', width: '100%'}}
                
            />

        </div>
    );
}

export default JobSearchTime;