import ReactECharts from 'echarts-for-react';  

function TagPieChart() {

    const option = {
        title: {
            text: 'Job Tags',
            subtext: '',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left'
        },
        series: [
            {
                name: 'Location',
                type: 'pie',
                radius: '50%',
                data: [
                    { value: 10, name: 'DevOps' },
                    { value: 50, name: 'Sr Engineering' },
                    { value: 100, name: 'React Frontend' },
                    { value: 200, name: 'Java Developer' },
                    { value: 40, name: 'Dot Net Developer' }
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    return (<div className='card'>
        
        <ReactECharts
            option={option}
            notMerge={true}
            lazyUpdate={true}
            theme={"theme_name"}
            style={{ height: '500px', width: '100%' }}

        />
    </div>);}

export default TagPieChart;